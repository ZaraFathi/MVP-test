package com.example.taskapplearn.mvp.presenter

import com.example.taskapplearn.mvp.ext.BaseLifeCycle
import com.example.taskapplearn.mvp.model.ModelMainActivity
import com.example.taskapplearn.mvp.view.ViewMainActivity

class PresenterMainActivity (
    private val view:ViewMainActivity,
    private val model:ModelMainActivity
)  :BaseLifeCycle {
    override fun onCreate() {
        setNewTask()
    }
    private fun setNewTask(){
        view.showDialog()

    }
}






