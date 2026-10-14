package co.edu.ucaldas.aplicacion1.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import co.edu.ucaldas.aplicacion1.Nombres

@Composable
fun HeroImage(
    imageUrl: String,
    contentDescription: String,
    modifier: Modifier = Modifier
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = contentDescription,
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun HeroInfo(
    hero: Nombres,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "ID: ${hero.id}",
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = hero.nombre,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(top = 4.dp)
        )
        Text(
            text = hero.descripcion,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "Superpoderes: ${hero.superPoderes.joinToString()}",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(top = 8.dp),
            color = MaterialTheme.colorScheme.primary
        )
    }
}

private fun heroProfile(superPoderes: List<String>): String = when {
    superPoderes.any { it.contains("Inteligencia", ignoreCase = true) } &&
            superPoderes.any { it.contains("Combate", ignoreCase = true) } -> "Estratega"
    superPoderes.any { it.contains("Energia", ignoreCase = true) } -> "Cósmico"
    superPoderes.any { it.contains("velocidad", ignoreCase = true) } -> "Velocista"
    else -> "Titán"
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroInfoDetail(
    hero: Nombres,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "HÉROE #${hero.id}",
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.secondary
                )
                Text(
                    text = hero.nombre,
                    style = MaterialTheme.typography.headlineMedium
                )
            }
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = hero.nombre.firstOrNull()?.toString() ?: "?",
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

        Surface(
            modifier = Modifier.fillMaxWidth(),
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surfaceVariant
        ) {
            Column(modifier = Modifier.padding(12.dp)) {
                Text("Perfil táctico: ${heroProfile(hero.superPoderes)}", style = MaterialTheme.typography.titleSmall)
                Spacer(modifier = Modifier.height(4.dp))
                Text(hero.descripcion, style = MaterialTheme.typography.bodyMedium)
            }
        }

        Text("Superpoderes", style = MaterialTheme.typography.titleMedium)

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            hero.superPoderes.forEach { poder ->
                AssistChip(
                    onClick = { },
                    label = { Text(poder) }
                )
            }
        }
    }
}

@Composable
fun HeroCard(
    hero: Nombres,
    onClick: (() -> Unit)? = null,
    option: Int = 0,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .then(
                if (onClick != null) {
                    Modifier.clickable { onClick() }
                } else {
                    Modifier
                }
            )
    ) {
        HeroImage(
            imageUrl = hero.imagenUrl,
            contentDescription = hero.nombre
        )
        if (option == 0) {
            HeroInfo(hero = hero)
        } else {
            HeroInfoDetail(hero = hero)
        }
    }
}