package com.debin.githubbrowser.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.debin.githubbrowser.HomeViewModel
import com.debin.githubbrowser.R
import com.debin.githubbrowser.databinding.FragmentUsersBinding

class UsersFragment : Fragment() {

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: FragmentUsersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUsersBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        binding.homeViewModel = viewModel
        binding.lifecycleOwner = this
    }

    private fun subscribeObserver() {
        viewModel.userList.observe(viewLifecycleOwner, Observer {

        })
    }


}