package com.joaorodrigues.taskscomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.joaorodrigues.taskscomposeapp.ui.theme.TasksComposeAppTheme
import com.joaorodrigues.taskscomposeapp.view.TasksList
import com.joaorodrigues.taskscomposeapp.view.TasksSave

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksComposeAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "tasksList") {
                    composable("tasksList") {
                        TasksList(navController)
                    }

                    composable("tasksSave") {
                        TasksSave(navController)
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }

}