package com.example.taskapplearn.mvp.view

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.taskapplearn.adapter.RecyclerTaskAdapter
import com.example.taskapplearn.databinding.ActivityMainBinding
import com.example.taskapplearn.databinding.CustomDialogBinding
import com.example.taskapplearn.databinding.DeleteItemDialogBinding
import com.example.taskapplearn.db.dao.TaskEntity
import com.example.taskapplearn.mvp.ext.OnBindData
import com.example.taskapplearn.mvp.model.ModelMainActivity

class ViewMainActivity(
    contextInstance: Context
) : FrameLayout(contextInstance) {
    val binding =
        ActivityMainBinding.inflate(LayoutInflater.from(context))
    private lateinit var adapter: RecyclerTaskAdapter
    fun initRecycler(tasks: ArrayList<TaskEntity>, onBindData: OnBindData) {

        adapter = RecyclerTaskAdapter(tasks, onBindData)
        binding.recyclerView.adapter = adapter
    }

    fun showTask(tasks: List<TaskEntity>) {
        val data = arrayListOf<TaskEntity>()
        tasks.forEach { data.add(it) }
        adapter.dataUpdate(data)
        binding.recyclerView.scrollToPosition(0)
    }

    fun setData(onBindData: OnBindData) {
        onBindData.requestData(false)
        binding.rdbTrue.setOnClickListener {
            onBindData.requestData(true)
        }
        binding.rdbFalse.setOnClickListener {
            onBindData.requestData(false)
        }
    }


    fun showDialog(onBindData: OnBindData) {
        binding.fab.setOnClickListener {
            val view = CustomDialogBinding.inflate(LayoutInflater.from(context))
            val dialog = Dialog(context)
            dialog.setContentView(view.root)
            dialog.setCancelable(false)
            dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            dialog.show()

            view.btnCancel.setOnClickListener { dialog.dismiss() }
            view.btnSave.setOnClickListener {
                val text = view.edtTask.text.toString()
                if (text.isNotEmpty()) {
                    onBindData.saveData(TaskEntity(title = text, state = false))
                    Toast.makeText(context, "وظیفه شما ایجاد شد", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()
                } else
                    Toast.makeText(context, "لطفا وظیفه را واردکنید", Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun showDeleteAlertDialog(taskEntity: TaskEntity,model: ModelMainActivity) {
        val view = DeleteItemDialogBinding.inflate(LayoutInflater.from(context))
        val dialog = Dialog(context)
        dialog.setContentView(view.root)
        dialog.setCancelable(false)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()

        view.btnCancel.setOnClickListener { dialog.dismiss() }
        view.btnSave.setOnClickListener {
                model.deleteData(taskEntity = taskEntity)
                Toast.makeText(context, "با موفقیت حذف شد!", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
        }
    }
}