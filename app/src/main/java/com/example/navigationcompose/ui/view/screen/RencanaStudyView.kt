package com.example.navigationcompose.ui.view.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.navigationcompose.R
import com.example.navigationcompose.model.Mahasiswa

@Composable
fun RencanaStudyView(
    mahasiswa: Mahasiswa,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    onBackButtonClicked: () -> Unit
){
    var chosenDropdown by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var pilihanKelas by remember { mutableStateOf("") }
    var listData: MutableList<String> = mutableListOf(chosenDropdown, pilihanKelas)

    Column (
        modifier = Modifier
            . fillMaxSize()
            .background(color = colorResource(id = R.color.primary))
    ) {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp), verticalAlignment = Alignment.CenterVertically
        ){
            Image(
                painter = painterResource(id = R.drawable.logoumy),
                contentDescription = "",
                modifier = Modifier
                    .clip(shape = CircleShape)
                    .size(50.dp)
            )

            Spacer(modifier = Modifier .padding(start = 16.dp))
        }


    }
}