package com.joaorodrigues.taskscomposeapp.datasource

import com.google.firebase.firestore.FirebaseFirestore
import com.joaorodrigues.taskscomposeapp.model.Task
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {

    private val db = FirebaseFirestore.getInstance()
    private val _allTasks = MutableStateFlow<MutableList<Task>>(mutableListOf())
    private val allTasks: StateFlow<MutableList<Task>> = _allTasks
    fun saveTask(title: String, description: String, priority: Int) {
        val taskMap =  hashMapOf(
            "title" to title,
            "description" to description,
            "priority" to priority
        )

        db.collection("tasks").document(title).set(
          taskMap
        ).addOnCompleteListener {

        }.addOnFailureListener() {

        }
    }

    fun getTasks(): Flow<MutableList<Task>> {

        val tasksList: MutableList<Task> = mutableListOf()
        db.collection("tasks").get().addOnCompleteListener {querySnapshot ->
            if (querySnapshot.isSuccessful) {
                for (document in querySnapshot.result) {
                    val task = document.toObject(Task::class.java)
                    tasksList.add(task)
                    _allTasks.value = tasksList

                }

            }

        }

        return allTasks
    }

    fun deleteTask(title: String) {
        db.collection("tasks").document(title).delete().addOnCompleteListener {

        }.addOnFailureListener {

        }
    }
}