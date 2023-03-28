package ru.anb.testapi.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import ru.anb.testapi.R
import ru.anb.testapi.adapter.ListAdapter
import ru.anb.testapi.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myAdapter: ListAdapter
    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myRecyclerView = view.findViewById(R.id.news_adapter)
        myAdapter = ListAdapter(listOf() )
        myRecyclerView.adapter = myAdapter
        initViewModel()
    }
    private fun initViewModel() {
        val viewModel: FragmentViewModel = ViewModelProvider(this)[FragmentViewModel::class.java]
//        viewModel.getLiveDataObserver().observe(viewLifecycleOwner, Observer {
//        })
        viewModel.loodPost()
    }
}