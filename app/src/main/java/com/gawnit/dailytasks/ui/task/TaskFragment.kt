package com.gawnit.dailytasks.ui.task

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ViewModel
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.databinding.FragmentTaskBinding

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

        arguments?.getInt("id")?.let {
            viewModel.findById(it).observe(viewLifecycleOwner) {
                binding.txtName.text = it.name
                binding.txtDate.text = it.date
                binding.txtStatus.text = it.status
                binding.txtDescription.text = it.description
            }
        }

        return binding.root
    }
}