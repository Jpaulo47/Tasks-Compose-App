package com.joaorodrigues.taskscomposeapp.view

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.joaorodrigues.taskscomposeapp.R
import com.joaorodrigues.taskscomposeapp.model.Task
import com.joaorodrigues.taskscomposeapp.repository.TasksRepository
import com.joaorodrigues.taskscomposeapp.ui.theme.Black
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_GREEN_ENABLED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_RED_SELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.RADIO_BUTTON_YELLOW_SELECTED
import com.joaorodrigues.taskscomposeapp.ui.theme.ShapeCard
import com.joaorodrigues.taskscomposeapp.ui.theme.White
import kotlinx.coroutines.launch

@Composable
fun ItemList(
    position: Int,
    tasks: MutableList<Task>,
    context: Context,
    navController: NavController
) {

    val titleTask = tasks[position].title
    val descriptionTask = tasks[position].description
    val priorityTask = tasks[position].priority

    val tasksRepository = TasksRepository()
    val scope = rememberCoroutineScope()
    
    fun deleteDialog() {

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("delete task")
        alertDialog.setMessage("Do you want to delete the task? $titleTask?")
        alertDialog.setPositiveButton("Yes") { _, _ ->
            tasksRepository.deleteTask(titleTask.toString())
            scope.launch {
                tasks.removeAt(position)
                navController.navigate("tasksList")
                Toast.makeText(context, "task deleted successfully", Toast.LENGTH_SHORT).show()
            }
        }
        alertDialog.setNegativeButton("No") { _, _ -> }
        alertDialog.show()
    }

    val priorityLevel: String = when (priorityTask) {
        0 -> "not priority"
        1 -> "low priority"
        2 -> "priority medium"
        3 -> "high priority"
        else -> "not priority"
    }

    val priorityColor = when (priorityTask) {
        0 -> Black
        1 -> RADIO_BUTTON_GREEN_ENABLED
        2 -> RADIO_BUTTON_YELLOW_SELECTED
        else -> RADIO_BUTTON_RED_SELECTED
    }

    Card(

        colors = CardDefaults.cardColors(containerColor = White),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)

    ) {

        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {

            val (title, description, cardPrioriry, textPriority, buttonDelete) = createRefs()

            Text(text = titleTask.toString(), modifier = Modifier.constrainAs(title) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
            })

            Text(text = descriptionTask.toString(), modifier = Modifier.constrainAs(description) {
                top.linkTo(title.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
            })

            Text(text = priorityLevel, modifier = Modifier.constrainAs(textPriority) {
                top.linkTo(description.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
                bottom.linkTo(parent.bottom, margin = 10.dp)
            })

            Card(
                colors = CardDefaults.cardColors(containerColor = priorityColor),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPrioriry) {
                        top.linkTo(description.bottom, margin = 10.dp)
                        start.linkTo(textPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCard.large
            ) {}

            IconButton(
                onClick = { deleteDialog() },
                modifier = Modifier.constrainAs(buttonDelete) {
                    top.linkTo(description.bottom, margin = 10.dp)
                    start.linkTo(cardPrioriry.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = "icon delete"
                )
            }

        }

    }
}