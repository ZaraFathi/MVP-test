package com.example.taskapplearn.mvp.model

import DBHandler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.taskapplearn.db.dao.TaskEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ModelMainActivity(private val activity: AppCompatActivity) {
     private val db =DBHandler.getDatabase(activity)
fun setData(taskEntity: TaskEntity){
    activity.lifecycleScope.launch {
        withContext(Dispatchers.IO){
            db.taskDao().insertTask(taskEntity)
        }
    }
}
}