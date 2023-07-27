package com.example.wikipedia.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentVideomakerBinding
import com.example.wikipedia.databinding.FragmentWriterBinding
import com.google.android.material.snackbar.Snackbar
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class FragmentVideoMaker : Fragment() {

    //create binding
    private lateinit var binding:FragmentVideomakerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVideomakerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide
            .with(requireContext())
            .load(R.drawable.img_videomaker)
            .transform(RoundedCornersTransformation(32, 8))
            .into(binding.imgVideoMaker)
    }
}