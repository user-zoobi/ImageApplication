package com.example.imagegallery.presentations.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.imagegallery.R
import com.example.imagegallery.databinding.FragmentBottomSheetBinding
import com.example.imagegallery.network.response.Pixabay
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetFragment(
    private val reponseData: Pixabay.Hit,
    private val webValue: KnowMoreWebVersion

) : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bottom_sheet, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.imagesItem = object : KnowMoreWebVersion {
            override fun knowMore(url: String) {
                webValue.knowMore(url)
            }
            override fun shareNow(urlData: String) {
                webValue.shareNow(urlData)
            }
        }
        binding.response = reponseData
        binding.executePendingBindings()
    }

    interface KnowMoreWebVersion {
        fun knowMore(url: String)
        fun shareNow(urlData:String)
    }
}