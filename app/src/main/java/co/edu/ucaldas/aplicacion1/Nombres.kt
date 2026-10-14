package co.edu.ucaldas.aplicacion1

data class Nombres(
    val id: Int,
    val nombre: String,
    val imagenUrl: String,
    val descripcion: String,
    val superPoderes: List<String>
)

val listaNombres = listOf(
    Nombres(
        1,
        "Superman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/644-superman.jpg",
        "Superman es un heroe de Superman Prime One-Million reconocido por ACTION COMICS #1.",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia")
    ),
    Nombres(
        2,
        "Batman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/70-batman.jpg",
        "Batman es un heroe de DC Comics reconocido por Detective Comics #27.",
        listOf("Inteligencia superior", "Combate experto")
    ),
    Nombres(
        3,
        "Wonder Woman",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/720-wonder-woman.jpg",
        "Wonder Woman es un heroe de DC Comics reconocido por All-Star Comics #8 (December, 1941).",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia")
    ),
    Nombres(
        4,
        "Spider-Man",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/620-spider-man.jpg",
        "Spider-Man es un heroe de Marvel Comics reconocido por Amazing Fantasy #15.",
        listOf("Inteligencia superior", "Alta resistencia", "Energia o poder especial", "Combate experto")
    ),
    Nombres(
        5,
        "Iron Man",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/346-iron-man.jpg",
        "Iron Man es un heroe de Marvel Comics reconocido por Tales of Suspence #39 (March, 1963).",
        listOf("Inteligencia superior", "Super fuerza", "Alta resistencia", "Energia o poder especial")
    ),
    Nombres(
        6,
        "Captain Marvel",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/157-captain-marvel.jpg",
        "Captain Marvel es un heroe de Binary reconocido por Ms. Marvel #1.",
        listOf("Inteligencia superior", "Super fuerza", "Super velocidad", "Alta resistencia")
    ),
    Nombres(
        7,
        "Captain America",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/149-captain-america.jpg",
        "Captain America es un heroe de Marvel Comics reconocido por Captain America Comics #1 (March 1941).",
        listOf("Combate experto")
    ),
    Nombres(
        8,
        "Thor",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/659-thor.jpg",
        "Thor es un heroe de Rune King Thor reconocido por Journey into Mystery #83 (August, 1962).",
        listOf("Super fuerza", "Super velocidad", "Alta resistencia", "Energia o poder especial")
    ),
    Nombres(
        9,
        "Hulk",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/332-hulk.jpg",
        "Hulk es un heroe de Marvel Comics reconocido por Incredible Hulk #1 (May, 1962).",
        listOf("Inteligencia superior", "Super fuerza", "Alta resistencia", "Energia o poder especial")
    ),
    Nombres(
        10,
        "Black Widow",
        "https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/images/lg/107-black-widow.jpg",
        "Black Widow es un heroe de Marvel Comics reconocido por Tales of Suspense #52.",
        listOf("Inteligencia superior", "Combate experto")
    )
)