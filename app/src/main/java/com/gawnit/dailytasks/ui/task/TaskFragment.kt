package com.gawnit.dailytasks.ui.task

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.databinding.FragmentTaskBinding

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding

    companion object {
        fun newInstance() = TaskFragment()
    }

    private lateinit var viewModel: TaskViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        val taskId = arguments?.getInt("id")
        println("Task on click $taskId")

        return binding.root
    }
}