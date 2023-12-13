package com.example.taskapplearn.mvp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import com.example.taskapplearn.databinding.ActivityMainBinding
import com.example.taskapplearn.databinding.CustomDialogBinding

class ViewMainActivity (
    contextInstance:Context
) :FrameLayout(contextInstance) {

    val binding =
        ActivityMainBinding.inflate(LayoutInflater.from(context))
    fun showDialog(){
        binding.fab.setOnClickListener {
            val view =CustomDialogBinding.inflate(LayoutInflater.from(context))
            val dialog = Dialog(context)
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            view.btnCancel.setOnClickListener { dialog.dismiss() }
            view.btnSave.setOnClickListener {
                val text = view.edtTask.text.toString()
                if(text.isNotEmpty()) {
                    //save to detabase
                }else
                      Toast.makeText(context,"لطفا وظیفه را واردکنید",Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

