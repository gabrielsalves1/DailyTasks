package com.gawnit.dailytasks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gawnit.dailytasks.R
import com.gawnit.dailytasks.databinding.ActivityMainBinding
import com.gawnit.dailytasks.ui.main.MainFragment
import com.gawnit.dailytasks.ui.taskform.TaskFormFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(MainFragment())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.tasks -> replaceFragment(MainFragment())
                R.id.create_task -> replaceFragment(TaskFormFragment())
            }

            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.frame_layout, fragment).commit()
    }
}