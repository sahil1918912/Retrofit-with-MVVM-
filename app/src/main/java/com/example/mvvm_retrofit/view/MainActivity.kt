package com.example.mvvm_retrofit.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvm_retrofit.ApiInterface
import com.example.mvvm_retrofit.R
import com.example.mvvm_retrofit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var rvMain : RecyclerView
    private lateinit var myAdapter: MyAdapter
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvMain = findViewById(R.id.recyclerView)
        rvMain.layoutManager = LinearLayoutManager(this)

        mainViewModel.users.observe(this, Observer { users ->
            myAdapter = MyAdapter(this,users)
            rvMain.adapter = myAdapter
        })

        mainViewModel.fetchUsers()

    }
}