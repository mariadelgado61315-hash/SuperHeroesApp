package co.edu.ucaldas.aplicacion1

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class SuperHeroesViewModel : ViewModel() {

    private val _superheroes = MutableStateFlow<List<Nombres>>(emptyList())
    val superheroes: StateFlow<List<Nombres>> = _superheroes.asStateFlow()

    init {
        cargarHeroes()
    }

    private fun cargarHeroes() {
        _superheroes.value = listaNombres
    }

    fun obtenerHeroePorId(id: Int): Nombres? {
        return _superheroes.value.firstOrNull { it.id == id }
    }
}