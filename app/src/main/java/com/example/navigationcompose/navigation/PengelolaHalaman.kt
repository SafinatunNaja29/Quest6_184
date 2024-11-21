package com.example.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.ui.view.screen.SplashView
import com.example.navigationcompose.ui.view.viewmodel.MahasiswaViewModel

enum class Halaman {
    Splash,
    Mahasiswa
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    navController: NavController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value

    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable (route = Halaman.Splash.name){
            SplashView (onMulaiButton = {
                navController.navigate()
            } ) { }
        }
    }
}