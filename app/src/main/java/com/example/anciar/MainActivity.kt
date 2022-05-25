package com.example.anciar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.example.anciar.adapter.ListAdapter
import com.example.anciar.databinding.ActivityMainBinding
import com.example.anciar.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this@MainActivity)[MainViewModel::class.java]
    }
    private lateinit var adapter: ListAdapter
    private lateinit var snapHelper: SnapHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.activity = this@MainActivity
        binding.rv.layoutManager = LinearLayoutManager(this@MainActivity, RecyclerView.VERTICAL, false)
        adapter = ListAdapter()
        binding.rv.adapter = adapter
        snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(binding.rv)
    }
}