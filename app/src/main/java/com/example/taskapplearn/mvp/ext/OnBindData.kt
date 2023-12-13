package com.example.taskapplearn.mvp.ext

import com.example.taskapplearn.db.dao.TaskEntity

interface OnBindData {
    fun saveData(taskEntity: TaskEntity){}
    fun editData(taskEntity: TaskEntity){}


}