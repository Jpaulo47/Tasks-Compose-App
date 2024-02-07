package com.joaorodrigues.taskscomposeapp.repository

import com.joaorodrigues.taskscomposeapp.datasource.DataSource
import com.joaorodrigues.taskscomposeapp.model.Task
import kotlinx.coroutines.flow.Flow

class TasksRepository{

    private val dataSource = DataSource()
    fun saveTask(title: String, description: String, priority: Int) {
        DataSource().saveTask(title, description, priority)
    }

    fun getTasks(): Flow<MutableList<Task>> {
        return dataSource.getTasks()
    }

    fun deleteTask(title: String) {
        dataSource.deleteTask(title)
    }
}