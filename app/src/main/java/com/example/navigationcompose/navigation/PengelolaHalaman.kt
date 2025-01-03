package com.example.navigationcompose.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.compose.composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.navigationcompose.model.Mahasiswa
import com.example.navigationcompose.ui.view.screen.MahasiswaFormView
import com.example.navigationcompose.ui.view.screen.RencanaStudyView
import com.example.navigationcompose.ui.view.screen.SplashView
import com.example.navigationcompose.ui.view.screen.TampilView
import com.example.navigationcompose.ui.view.viewmodel.MahasiswaViewModel
import com.example.navigationcompose.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    MataKuliah,
    TampilKRS
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    RencanaStudyViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    val rencanaStudiUiState = RencanaStudyViewModel.krsStateUi.collectAsState().value


    NavHost(
        navController = navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ) {
        composable (route = Halaman.Splash.name){
            SplashView (onMulaiButton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
        composable (route = Halaman.Mahasiswa.name){
            MahasiswaFormView(
                onSubmitButtonClicked = {
                mahasiswaViewModel.saveDataMahasiswa(it)
                navController.navigate(Halaman.MataKuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable (route = Halaman.MataKuliah.name){
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {
                    RencanaStudyViewModel.saveDataKRS(it)
                navController.navigate(Halaman.TampilKRS.name)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(route = Halaman.TampilKRS.name) {
            TampilView(
                mahasiswa = mahasiswaUiState,
                krs = rencanaStudiUiState,
                onbackbuttonClicked = {
                    navController.popBackStack()
                },
                onResetButtonClicked = {
                    navController.navigate(Halaman.Splash.name)
                }

            )
        }
    }
}
