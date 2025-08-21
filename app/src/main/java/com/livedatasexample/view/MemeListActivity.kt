package com.livedatasexample.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.livedatasexample.databinding.ActivityMemeListBinding
import com.livedatasexample.model.Meme
import com.livedatasexample.model.MemeResponse
import com.livedatasexample.model.PhotosResponse
import com.livedatasexample.utils.ApiResponseCallBack
import com.livedatasexample.viewmodel.MemeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.core.content.ContextCompat.startActivity

@AndroidEntryPoint
class MemeListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemeListBinding
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var listAdapter: MemeAdapter
    private val viewModel : MemeViewModel by viewModels()
//    private var page : Int =1
//    private val limit = 2
//    private var isLoading =false

    private var currentPage = 1
    private val pageSize = 20
    private var isLoading = false
    private val allMemes = mutableListOf<PhotosResponse>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemeListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpScroller()
        observer()
        viewModel.getMeme(currentPage , pageSize)
        binding.btn.setOnClickListener {
        }
    }

    private fun setUpScroller() {
        linearLayoutManager = LinearLayoutManager(this ,RecyclerView.VERTICAL,false)
        binding.rvList.layoutManager = linearLayoutManager
        listAdapter = MemeAdapter(this )
        binding.rvList.adapter = listAdapter

        binding.rvList.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                val layoutManager = recyclerView.layoutManager as LinearLayoutManager
                val visibleItemCount = layoutManager.childCount
                val totalItemCount = layoutManager.itemCount
                val firstVisiblePosition = layoutManager.findLastVisibleItemPosition()

                if (!isLoading  && (visibleItemCount+firstVisiblePosition) >= totalItemCount) {
                    isLoading = true
                    currentPage++
                    viewModel.getMeme(currentPage,pageSize)
                }
            }
        })
    }

    private fun observer() {
         lifecycleScope.launch {
             viewModel.meme.collect {
                  when(it) {
                      is ApiResponseCallBack.Error<*> -> {
                          Log.d("1234", "observer: Error ${it.message}")
                          binding.progress.visibility = View.GONE
                          isLoading = false

                      }
                      is ApiResponseCallBack.Loading<*> -> {
                          Log.d("1234", "observer: Progress")
                          isLoading = true
                            binding.progress.visibility = View.VISIBLE
                      }
                      is ApiResponseCallBack.Success<*> -> {
                          isLoading = false
                          binding.progress.visibility = View.GONE
                          var response = it.data as List<PhotosResponse>
                          listAdapter.addItems(response)
                      }
                      null -> {}
                  }
             }
         }
    }

    private fun dataListAdapter(listData : MutableList<Meme>) {
        linearLayoutManager = LinearLayoutManager(this ,RecyclerView.VERTICAL,false)
        binding.rvList.layoutManager = linearLayoutManager
        listAdapter = MemeAdapter(this )
        binding.rvList.adapter = listAdapter
    }
}