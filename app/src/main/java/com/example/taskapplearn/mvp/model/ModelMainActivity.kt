package com.example.taskapplearn.mvp.model

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.taskapplearn.db.DBHandler
import com.example.taskapplearn.db.dao.TaskEntity
import com.example.taskapplearn.mvp.ext.OnBindData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ModelMainActivity(private val activity: AppCompatActivity) {
    private val db = DBHandler.getDatabase(activity)
    fun setData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().insertTask(taskEntity)
            }
        }
    }
    fun deleteData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().deleteTasks(taskEntity)
            }
        }
    }
    fun editData(taskEntity: TaskEntity) {
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO) {
                db.taskDao().updateTasks(taskEntity)
            }
        }
    }
    fun  getData(state:Boolean,onBindData: OnBindData){
        activity.lifecycleScope.launch {
            withContext(Dispatchers.IO){
                val tasks =db.taskDao().getTasksByColumn(state)
                withContext(Dispatchers.Main){
                    tasks.collect {
                        onBindData.getData(it)
                    }
                }
            }
        }
    }

    fun closeDatabase() {
        db.close()
    }
}
