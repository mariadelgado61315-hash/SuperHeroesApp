package co.edu.ucaldas.aplicacion1

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import co.edu.ucaldas.aplicacion1.ui.theme.HeroCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val viewModel: SuperHeroesViewModel = viewModel()
                    SuperHeroesListScreen(viewModel = viewModel)
                }
            }
        }
    }
}

@Composable
fun SuperHeroesListScreen(
    viewModel: SuperHeroesViewModel
) {
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }

    // Estado para guardar los "Me gusta" o selección de cada superhéroe por su ID
    val likesMap = remember { mutableStateMapOf<Int, Int>() }

    // Obtenemos la lista del StateFlow superheroes
    val heroesList by viewModel.superheroes.collectAsState()

    val filteredHeroes: List<Nombres> = heroesList.filter { hero ->
        hero.nombre.contains(searchQuery, ignoreCase = true) ||
                hero.descripcion.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Campo de búsqueda
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            label = { Text("Buscar superhéroe...") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 12.dp),
            singleLine = true
        )

        // Si la búsqueda no arroja resultados
        if (filteredHeroes.isEmpty()) {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text("No se encontraron superhéroes")
            }
        } else {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(
                    count = filteredHeroes.size
                ) { index ->
                    val heroItem: Nombres = filteredHeroes[index]
                    val currentOption = likesMap[heroItem.id] ?: 0

                    HeroCard(
                        hero = heroItem,
                        option = currentOption,
                        onClick = {
                            // Incrementa el contador o activa la opción al presionar
                            likesMap[heroItem.id] = currentOption + 1
                            Toast.makeText(
                                context,
                                "¡Te gusta ${heroItem.nombre}!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
                }
            }
        }
    }
}