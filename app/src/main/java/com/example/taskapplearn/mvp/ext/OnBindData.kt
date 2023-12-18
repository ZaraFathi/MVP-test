package com.example.taskapplearn.mvp.ext

import com.example.taskapplearn.db.dao.TaskEntity

interface OnBindData {
    fun saveData(taskEntity: TaskEntity){}
    fun editData(taskEntity: TaskEntity){}
    fun deleteData(taskEntity: TaskEntity){}
    fun getData(taskEntity:List<TaskEntity>){}
    fun requestData(state:Boolean) {}
}