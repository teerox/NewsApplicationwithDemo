package com.example.newsapplication.screen.newsfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapplication.NewsApplication

import com.example.newsapplication.R
import com.example.newsapplication.databinding.FragmentNewsBinding
import com.example.newsapplication.model.Result
import com.example.newsapplication.viewmodel.AllViewModel
import com.example.newsapplication.viewmodel.ViewModelFactory

/**
 * A simple [Fragment] subclass.
 */
class NewsFragment : Fragment() {
    lateinit var recyclerView: RecyclerView

    lateinit var adapter: Adapter
    lateinit var binding:FragmentNewsBinding
    var arrayMovies = arrayListOf<Result>()
    private val newsViewModel by viewModels<AllViewModel> {
        ViewModelFactory((requireContext().applicationContext as NewsApplication).newsRepository)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news,container,false)

        recyclerView = binding.recy

        adapter = Adapter(requireContext(),arrayMovies) {}
        newsViewModel.items.observe(viewLifecycleOwner, Observer {
            val news = it
            adapter.newArrayList = news as ArrayList<Result>
            val list = adapter.newArrayList
            adapter = Adapter(requireContext(),list) {
                result ->
                val action = NewsFragmentDirections.actionNewsFragmentToNewsContentFragment(result)
                findNavController().navigate(action)
            }
            recyclerView.adapter = adapter
        })




        return binding.root
    }

}
