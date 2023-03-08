package com.example.uklmyrecyclerview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class FragmentSecond : Fragment() {
    private var communicationViewModel: CommunicationViewModel? = null
    private var txtName: TextView? = null
    private var txtEmail: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        communicationViewModel = ViewModelProviders.of(requireActivity()).get(CommunicationViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        txtName = view.findViewById(R.id.textViewName)
        txtEmail = view.findViewById(R.id.textViewEmail)
        communicationViewModel!!.name.observe(requireActivity(), Observer{S ->txtName!!.text = S})
        communicationViewModel!!.email.observe(requireActivity(), Observer{S ->txtEmail!!.text = S})
    }

    companion object {
        fun newInstance(): FragmentSecond {
            return FragmentSecond()
        }
    }
}