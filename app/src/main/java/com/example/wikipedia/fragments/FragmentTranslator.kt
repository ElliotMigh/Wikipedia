package com.example.wikipedia.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentPhotographerBinding
import com.example.wikipedia.databinding.FragmentProfileBinding
import com.example.wikipedia.databinding.FragmentTranslatorBinding
import com.google.android.material.card.MaterialCardView
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

class FragmentTranslator : Fragment() {

    //create binding:
    lateinit var binding: FragmentTranslatorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTranslatorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide
            .with(requireContext())
            .load(R.drawable.img_translator2)
            .transform(RoundedCornersTransformation(32, 8))
            .into(binding.imgTranslator)
    }
}