package com.gawnit.dailytasks.ui.taskform

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.databinding.FragmentTaskFormBinding
import com.gawnit.dailytasks.ui.main.MainFragment
import org.json.JSONObject

class TaskFormFragment : Fragment() {
    private lateinit var binding: FragmentTaskFormBinding
    private lateinit var viewModel: TaskFormViewModel

    companion object {
        fun newInstance() = TaskFormFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTaskFormBinding.inflate(inflater, container, false)

        binding.btnSaveTask.setOnClickListener {
            val name = binding.editTaskName.text.toString()
            val description = binding.editTaskDescription.text.toString()
            val taskDate = binding.editTaskDate.text.toString()
            val statusId = binding.rgStatus.checkedRadioButtonId

            lateinit var status: String
            when (statusId) {
                R.id.rb_to_do -> status = binding.rbToDo.text.toString()
                R.id.rb_in_progress -> status = binding.rbToDo.text.toString()
                R.id.rb_done -> status = binding.rbToDo.text.toString()
            }

            val data = JSONObject(
                "{\n" +
                        "\"name\": \"$name\"," +
                        "\"description\": \"$description\"," +
                        "\"date\": \"$taskDate\"," +
                        "\"status\": \"$status\"" +
                        "\n}"
            )

            viewModel = ViewModelProvider(this).get(TaskFormViewModel::class.java)

            if (container != null) {
                viewModel.writeFile(container.context, data)
                parentFragmentManager.beginTransaction().replace(R.id.frame_layout, MainFragment()).commit()
            }
        }

        return binding.root
    }
}