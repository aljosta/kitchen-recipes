# App de Recetas
Esta es una aplicación que permite la consulta de recetas mediante un campo de búsqueda, listado de resultados, visualización del detalle de cada resultado encontrado y visualización de ubicación del origen de la receta.

## Funcionalidades
La aplicación contiene las siguiente características:

* Pantalla inicial que contiene un campo de búsqueda por palabra clave y el listado de las recetas.
* Pantalla con el detalle de la receta.
* Pantalla de mapa con la ubicación del origen de la receta.

## Guía de implementación

### API
El listado de recetas y la consulta del detalle es realizada mediante una API generada en la plataforma de mockable.io utilizando la librería de Retrofit.

### Arquitectura
Se utiliza el patrón de arquitectura MVVM y basado en la guía de arquitectura de Android y arquitectura limpia (Clean Architecture) que permite tener el código desacoplado y mantenible. La capas se agrupan por funcionalidades de la aplicación.

###
* UI: MainActivity, RecipeListView, RecipeDetailView, HomeView, LocationView, HomeViewModel, RecipeDetailViewModel
* Domain: GetAllRecipesUseCase, GetRecipeDetailUseCase, FilterRecipesByKeywordUseCase
* Data: RecipeDataRepository, RecipeRemoteDataSource


### Inyección de dependencias
Se utiliza hilt para la inserción de dependencias y evitar acoplamiento dentro de las clases del proyecto, esto permite centralizar la inicialización de dependencias en módulos donde pueden ser facilmente reemplazadas por otras implementaciones.

### Jetpack Compose
Se utiliza la librería de jetpack compose para la generación de la interfaces gráficas y la navegación de la aplicación.

### Coroutines
Se hace uso de coroutines para la ejecución de los llamados a los servicos web por medio de threads y asi evitar el bloqueo del thread gráfico y permitir una mayor fluidez en la aplicación.

### Unit testing
Se desarrollaron test unitarios con el fin de la validación de la lógica en la aplicación y aseguramiento de la calidad para futuros modificaciones en el codebase.

### Google Maps Services
Se utilizó la api de google map services para construir la pantalla con el map y la ubicación del marcador correspondiente al origen de la receta.
