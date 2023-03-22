package com.example.recipesapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.core.utils.Constants
import com.example.core.utils.value
import com.example.recipesapp.home.ui.views.HomeView
import com.example.recipesapp.location.ui.views.LocationView
import com.example.recipesapp.recipedetail.ui.views.RecipeDetailView

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object RecipeDetail : Screen("recipe/{${NavArgs.RecipeId.key}}") {
        fun createRoute(recipeId: String) = "recipe/$recipeId"
    }
    object Location : Screen(
        "location?${NavArgs.Latitude.key}={${NavArgs.Latitude.key}}" +
            "&${NavArgs.Longitude.key}={${NavArgs.Longitude.key}}",
    ) {
        fun createRoute(lat: Float, lng: Float) =
            "location?${NavArgs.Latitude.key}=$lat" +
                "&${NavArgs.Longitude.key}=$lng"
    }
}

enum class NavArgs(val key: String) {
    RecipeId("recipeId"),
    RecipeTitle("recipeTitle"),
    Latitude("lat"),
    Longitude("lng"),
}

@Composable
fun RecipeAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Screen.Home.route,
) {
    NavHost(modifier = modifier, navController = navController, startDestination = startDestination) {
        composable(Screen.Home.route) {
            HomeView(
                navigateToDetail = { recipeId ->
                    navController.navigate(Screen.RecipeDetail.createRoute(recipeId))
                },
            )
        }

        composable(
            route = Screen.RecipeDetail.route,
            arguments = listOf(
                navArgument(NavArgs.RecipeId.key) {
                    defaultValue = Constants.EMPTY_STRING
                    type = NavType.StringType
                },
            ),
        ) {
            RecipeDetailView(
                navigateToMap = { location ->
                    navController.navigate(
                        Screen.Location.createRoute(
                            location[0].toFloat(),
                            location[1].toFloat(),
                        ),
                    )
                },
                navigateUp = { navController.navigateUp() },
            )
        }

        composable(
            route = Screen.Location.route,
            arguments = listOf(
                navArgument(NavArgs.Latitude.key) {
                    type = NavType.FloatType
                },
                navArgument(NavArgs.Longitude.key) {
                    type = NavType.FloatType
                },
            ),
        ) { navBackStackEntry ->
            val latitude = navBackStackEntry.arguments?.getFloat(NavArgs.Latitude.key).value()
            val longitude = navBackStackEntry.arguments?.getFloat(NavArgs.Longitude.key).value()
            LocationView(
                location = listOf(latitude, longitude),
                navigateUp = { navController.navigateUp() },
            )
        }
    }
}
