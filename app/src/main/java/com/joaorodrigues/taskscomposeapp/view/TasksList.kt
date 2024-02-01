package com.joaorodrigues.taskscomposeapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joaorodrigues.taskscomposeapp.R
import com.joaorodrigues.taskscomposeapp.ui.theme.Black
import com.joaorodrigues.taskscomposeapp.ui.theme.Purple40
import com.joaorodrigues.taskscomposeapp.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksList(
    navController: NavController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tasks",
                        color = White,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple40)
            )
        },
        containerColor = Black,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("tasksSave") },
                containerColor = Purple40
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_add),
                    contentDescription = navController.context.getString(R.string.add_task)
                )
            }
        }
    ) {

    }

}