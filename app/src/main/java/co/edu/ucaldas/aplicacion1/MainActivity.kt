package co.edu.ucaldas.aplicacion1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import co.edu.ucaldas.aplicacion1.ui.theme.Aplicacion1Theme
import co.edu.ucaldas.aplicacion1.ui.theme.HeroCard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Aplicacion1Theme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: SuperHeroesViewModel = viewModel()) {
    val navController = rememberNavController()
    val superheroes by viewModel.superheroes.collectAsState()

    NavHost(
        navController = navController,
        startDestination = Utils.Rutas.LISTA
    ) {
        composable(Utils.Rutas.LISTA) {
            ListaSuperHeroes(
                superheroes = superheroes,
                onVerDetalle = { id ->
                    navController.navigate(Utils.Rutas.detalle(id))
                }
            )
        }

        composable(
            route = Utils.Rutas.DETALLE,
            arguments = listOf(navArgument("id") { type = NavType.IntType })
        ) { backStackEntry ->
            val id = backStackEntry.arguments?.getInt("id") ?: return@composable
            val hero = viewModel.obtenerHeroePorId(id) ?: return@composable

            DetalleSuperHeroe(
                hero = hero,
                onVolver = { navController.popBackStack() }
            )
        }
    }
}

@Composable
fun ListaSuperHeroes(
    superheroes: List<Nombres>,
    onVerDetalle: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(superheroes, key = { it.id }) { heroe ->
            HeroCard(
                hero = heroe,
                onClick = { onVerDetalle(heroe.id) }
            )
        }
    }
}

@Composable
fun DetalleSuperHeroe(
    hero: Nombres,
    onVolver: () -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            HeroCard(hero = hero, option = 1)
        }
        item {
            Button(
                onClick = onVolver,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Volver a la lista")
            }
        }
    }
}