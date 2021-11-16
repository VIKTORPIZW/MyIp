package com.example.ip

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.SavedStateViewModelFactory
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders


class IpFragment : Fragment(R.layout.fragment_ip) {



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val ipViewModel = ViewModelProvider(this)[IpViewModel::class.java]

        val textView:TextView = view.findViewById(R.id.txt_ip_address)
        val button:Button = view.findViewById(R.id.button)

        button.setOnClickListener {
            ipViewModel.mutableLiveData.observe(viewLifecycleOwner,{
                textView.text = it.ip
            })
        }

        }
    }





