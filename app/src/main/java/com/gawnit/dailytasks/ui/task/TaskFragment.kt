package com.gawnit.dailytasks.ui.task

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.gawnit.dailytasks.databinding.FragmentTaskBinding
import com.gawnit.dailytasks.util.dateFormatPtBR

class TaskFragment : Fragment() {
    private lateinit var binding: FragmentTaskBinding
    private lateinit var viewModel: TaskViewModel

    companion object {
        fun newInstance() = TaskFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentTaskBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(TaskViewModel::class.java)

        arguments?.getInt("id")?.let { id ->
            viewModel.findById(id).observe(viewLifecycleOwner) { task ->
                binding.txtName.text = task.name
                binding.txtDate.text = dateFormatPtBR(task.date)
                binding.txtStatus.text = task.status
                binding.txtDescription.text = task.description
            }
        }

        return binding.root
    }
}