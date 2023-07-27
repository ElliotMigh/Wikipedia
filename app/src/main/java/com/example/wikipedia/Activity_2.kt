package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.view.MenuItem
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.wikipedia.data.ItemPost
import com.example.wikipedia.databinding.Activity2Binding
import com.example.wikipedia.fragments.SEND_DATA_TO_SECOND_ACTIVITY
import kotlinx.parcelize.Parcelize

class Activity_2 : AppCompatActivity() {
    lateinit var binding: Activity2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Activity2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        //support toolbar
        setSupportActionBar(binding.toolbarAsli)
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)


        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)
        if (dataPost != null) {
            showData(dataPost)
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

    private fun showData(itemPost: ItemPost) {

        Glide
            .with(this)
            .load( itemPost.imgUrl )
            .into( binding.imgDetail )

        binding.txtDetailTitle.text = itemPost.txtTitle
        binding.txtDetailSubtitle.text = itemPost.txtSubTitle
        binding.txtDetailText.text = itemPost.txtDetail

        binding.fabDetailOpenWikipedia.setOnClickListener {

            // open wikipedia
            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent( Intent.ACTION_VIEW , Uri.parse(url) )
            startActivity(intent)

        }

    }
}
