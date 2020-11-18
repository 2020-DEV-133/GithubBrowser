package com.debin.githubbrowser.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.debin.githubbrowser.BaseFragment
import com.debin.githubbrowser.HomeViewModel
import com.debin.githubbrowser.R
import com.debin.githubbrowser.databinding.FragmentSearchBinding


class SearchFragment : BaseFragment() {

    private lateinit var binding : FragmentSearchBinding
    private lateinit var viewModel : HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
               viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
               binding.homeViewModel = viewModel
               binding.lifecycleOwner = this
    }

    private fun subscribeObserver() {
        viewModel.userList.observe(viewLifecycleOwner, Observer {

        })
    }

    private fun initViews() {

    }

}