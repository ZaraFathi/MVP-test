package com.example.taskapplearn.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskapplearn.mvp.model.ModelMainActivity
import com.example.taskapplearn.mvp.presenter.PresenterMainActivity
import com.example.taskapplearn.mvp.view.ViewMainActivity

class MainActivity : AppCompatActivity() {
    private lateinit var presenter:PresenterMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val view=ViewMainActivity(this)
        setContentView(view.binding.root)
        presenter=PresenterMainActivity(view,ModelMainActivity(activity = this))
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }



}