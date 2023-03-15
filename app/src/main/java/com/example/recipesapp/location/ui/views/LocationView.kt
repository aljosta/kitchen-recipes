package com.example.recipesapp.location.ui.views

import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.recipesapp.R
import com.example.recipesapp.ui.view.TopBar
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.*

@Composable
fun LocationView(
    location: List<Float>,
    navigateUp: () -> Unit,
) {
    val recipeMarker = LatLng(location[0].toDouble(), location[1].toDouble())
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(recipeMarker, 5f)
    }

    Scaffold(
        topBar = {
            TopBar(
                title = stringResource(id = R.string.recipe_location_top_bar_title),
                icon = Icons.Default.ArrowBack,
                onIconClick = navigateUp,
            )
        },
    ) { paddingValues ->
        LocationView(
            marker = recipeMarker,
            cameraPositionState = cameraPositionState,
            modifier = Modifier.padding(paddingValues),
        )
    }
}

@Composable
fun LocationView(
    marker: LatLng,
    cameraPositionState: CameraPositionState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState,
        ) {
            Marker(
                state = MarkerState(position = marker),
            )
        }
    }
}

@Preview
@Composable
fun PreviewLocation() {
}
