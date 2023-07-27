package com.example.wikipedia.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.R
import com.example.wikipedia.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.snackbar.Snackbar

class FragmentProfile : Fragment() {

    //create binding:
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //click on img twitter
        binding.imgTwitter.setOnClickListener {
            Snackbar.make(binding.root, "You Wanna see a Twitter?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    openSocialWebsite("https://twitter.com/elliotmigh?t=7QzN7RtEqFTC1Qo2mSymOQ&s=09")
                }
                .setActionTextColor(ContextCompat.getColor((requireContext()), R.color.white))
                .setBackgroundTint(ContextCompat.getColor((requireContext()), R.color.blue))
                .show()
        }
        //click on img phone
        binding.imgPhone.setOnClickListener {
            Snackbar.make(binding.root, "You Wanna see a Number?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    val mobileNumber = "09115230019"
                    val dialIntentPhone = Intent(Intent.ACTION_DIAL)
                    dialIntentPhone.data = Uri.parse("tel: " + "${mobileNumber}")
                    startActivity(dialIntentPhone)
                }
                .setActionTextColor(ContextCompat.getColor((requireContext()), R.color.white))
                .setBackgroundTint(ContextCompat.getColor((requireContext()), R.color.blue))
                .show()
        }
        //click on img instagram
        binding.imgInstagram.setOnClickListener {
            Snackbar.make(binding.root, "You Wanna see a Instagram?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    openSocialWebsite("https://instagram.com/matinmighani_dev?igshid=NGExMmI2YTkyZg==")
                }
                .setActionTextColor(ContextCompat.getColor((requireContext()), R.color.white))
                .setBackgroundTint(ContextCompat.getColor((requireContext()), R.color.blue))
                .show()
        }
        //click on img github
        binding.imgGithub.setOnClickListener {
            Snackbar.make(binding.root, "You Wanna see a Github?", Snackbar.LENGTH_LONG)
                .setAction("YES") {
                    openSocialWebsite("https://github.com/ElliotMigh")
                }
                .setActionTextColor(ContextCompat.getColor((requireContext()), R.color.white))
                .setBackgroundTint(ContextCompat.getColor((requireContext()), R.color.blue))
                .show()
        }
    }

    private fun openSocialWebsite(urlSocial: String) {
        val intentSocialUrl = Intent(Intent.ACTION_VIEW, Uri.parse(urlSocial))
        startActivity(intentSocialUrl)
    }
}