package com.joaorodrigues.taskscomposeapp.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.joaorodrigues.taskscomposeapp.components.ButtonSave
import com.joaorodrigues.taskscomposeapp.components.TextBox
import com.joaorodrigues.taskscomposeapp.ui.theme.Purple40
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_GREEN_DISABLED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_GREEN_ENABLED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_RED_UNSELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_YELLOW_UNSELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TasksSave(
    navController: NavController
) {

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Tasks Save",
                        color = White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }, colors = TopAppBarDefaults.topAppBarColors(containerColor = Purple40)
            )
        }

    ) {

        var titleTask by remember { mutableStateOf("") }
        var descriptionTask by remember { mutableStateOf("") }
        var priorityEmpty by remember { mutableStateOf(false) }
        var priorityLow by remember { mutableStateOf(false) }
        var priorityMedium by remember { mutableStateOf(false) }
        var priorityHigh by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            TextBox(
                value = titleTask,
                onValueChange = {
                    titleTask = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 0.dp),
                label = "Title Task",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )

            TextBox(
                value = descriptionTask,
                onValueChange = {
                    descriptionTask = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 20.dp, 20.dp, 0.dp),
                label = "Title Task",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 10.dp, 20.dp, 0.dp)
            ) {

                Text(text = "Priority Level", fontSize = 18.sp, fontWeight = FontWeight.Bold)

                RadioButton(
                    selected = priorityLow,
                    onClick = {
                        priorityLow = !priorityLow
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_GREEN_DISABLED,
                        unselectedColor = RADIO_BUTTON_GREEN_ENABLED
                    )
                )

                RadioButton(
                    selected = priorityMedium,
                    onClick = {
                        priorityMedium = !priorityMedium
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_YELLOW_UNSELECTED,
                        unselectedColor = RADIO_BUTTON_YELLOW_SELECTED
                    )
                )

                RadioButton(
                    selected = priorityHigh,
                    onClick = {
                        priorityHigh = !priorityHigh
                    },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = RADIO_BUTTON_RED_UNSELECTED,
                        unselectedColor = RADIO_BUTTON_RED_SELECTED
                    )
                )

            }

            ButtonSave(
                onClick = {
                    /*TODO*/
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .padding(20.dp, 20.dp, 20.dp, 20.dp),
                text = "Save Task"
            )


        }

    }
}
