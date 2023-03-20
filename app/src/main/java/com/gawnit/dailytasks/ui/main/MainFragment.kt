package com.gawnit.dailytasks.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.gawnit.dailytasks.adapter.TaskAdapter
import com.gawnit.dailytasks.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)

        binding.rcTasks.layoutManager = LinearLayoutManager(requireContext())
        binding.rcTasks.setHasFixedSize(true)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.findAll.observe(viewLifecycleOwner) { listTask ->
            val adapter = TaskAdapter(requireContext(), listTask)
            binding.rcTasks.adapter = adapter
        }

        return binding.root
    }
}