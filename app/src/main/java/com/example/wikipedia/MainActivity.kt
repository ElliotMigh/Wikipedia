package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.fragment.app.Fragment
import cn.pedant.SweetAlert.SweetAlertDialog
//import cn.pedant.SweetAlert.SweetAlertDialog
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.databinding.FragmentPhotographerBinding
import com.example.wikipedia.fragments.*
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //support action bar
        setSupportActionBar(binding.toolbarMain)

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.openDrawer,
            R.string.closeDrawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.menu_writer -> {
                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //sweet dialog
                    val dialogWriter = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialogWriter.titleText = "Alert"
                    dialogWriter.confirmText = "Confirm"
                    dialogWriter.cancelText = "Cancel"
                    dialogWriter.contentText = "Wanna be a write?!"

                    //click on confirm button
                    dialogWriter.setConfirmClickListener {
                        //load fragment
                        val transaction = supportFragmentManager.beginTransaction()
                        //replace fragment
                        transaction.replace(R.id.frame_main_container, FragmentWriter())
                        //add to back stack for press back button
                        transaction.addToBackStack(null)
                        //commit fragment
                        transaction.commit()
                        //dismiss dialog
                        dialogWriter.dismiss()
                    }
                    //click on cancel button
                    dialogWriter.setCancelClickListener {
                        Toast.makeText(this, "ok!!!", Toast.LENGTH_SHORT).show()
                        dialogWriter.dismiss()
                    }
                    //show sweet dialog
                    dialogWriter.show()

                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //set check in my item in navigation drawer
                    binding.navigationViewMain.menu.getItem(0).isChecked = true


                }
                R.id.menu_photographer -> {

                    val dialogPhotographer = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialogPhotographer.titleText = "Alert"
                    dialogPhotographer.confirmText = "Confirm"
                    dialogPhotographer.cancelText = "Cancel"
                    dialogPhotographer.contentText = "Wanna be a photograph?!"

                    //click on cancel button
                    dialogPhotographer.setCancelClickListener {
                        Toast.makeText(this, "ok!!", Toast.LENGTH_SHORT).show()
                        dialogPhotographer.dismiss()
                    }

                    //click on confirm button
                    dialogPhotographer.setConfirmClickListener {
                        //load fragment
                        val transaction = supportFragmentManager.beginTransaction()
                        //replace fragment
                        transaction.replace(R.id.frame_main_container, FragmentPhotographer())
                        //add to back stack for press back button
                        transaction.addToBackStack(null)
                        //commit fragment
                        transaction.commit()

                        //dismiss dialog
                        dialogPhotographer.dismiss()
                    }

                    //show dialog
                    dialogPhotographer.show()

                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //set check in my item in navigation drawer
                    binding.navigationViewMain.menu.getItem(1).isChecked = true
                }
                R.id.menu_videomaker -> {

                    val dialogVideoMaker = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialogVideoMaker.titleText = "Alert"
                    dialogVideoMaker.contentText = "Wanna be a video maker?"
                    dialogVideoMaker.confirmText = "Confirm"
                    dialogVideoMaker.cancelText = "Cancel"

                    //click on confirm button
                    dialogVideoMaker.setConfirmClickListener {
                        //load fragment
                        val transaction = supportFragmentManager.beginTransaction()
                        //replace fragment
                        transaction.replace(R.id.frame_main_container, FragmentVideoMaker())
                        //add to back stack
                        transaction.addToBackStack(null)
                        //commit
                        transaction.commit()

                        //dismiss dialog
                        dialogVideoMaker.dismiss()
                    }
                    //click on cancel button
                    dialogVideoMaker.setCancelClickListener {
                        Toast.makeText(this, "ok!!", Toast.LENGTH_SHORT).show()
                        dialogVideoMaker.dismiss()
                    }

                    //show dialog
                    dialogVideoMaker.show()

                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //set check in my item in navigation drawer
                    binding.navigationViewMain.menu.getItem(2).isChecked = true
                }
                R.id.menu_translator -> {

                    val dialogTranslator = SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    dialogTranslator.titleText = "Alert"
                    dialogTranslator.contentText = "Wanna be a translator?"
                    dialogTranslator.confirmText = "Confirm"
                    dialogTranslator.cancelText = "Cancel"

                    //click on confirm button
                    dialogTranslator.setConfirmClickListener {
                        //load fragment
                        val transaction = supportFragmentManager.beginTransaction()
                        //replace fragment
                        transaction.replace(R.id.frame_main_container, FragmentTranslator())
                        //add to back stack
                        transaction.addToBackStack(null)
                        //commit
                        transaction.commit()
                        //dismiss dialog
                        dialogTranslator.dismiss()
                    }
                    //click on cancel button
                    dialogTranslator.setCancelClickListener {
                        Toast.makeText(this, "Ok!!", Toast.LENGTH_SHORT).show()
                        dialogTranslator.dismiss()
                    }

                    //show dialog
                    dialogTranslator.show()

                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                    //set check in my item in navigation drawer
                    binding.navigationViewMain.menu.getItem(3).isChecked = true
                }
                R.id.menu_open_wikipedia -> {
                    Snackbar.make(binding.root, "You Wanna see a Wikipedia?", Snackbar.LENGTH_LONG)
                        .setAction("See") {
                            openWebsite("https://www.wikipedia.org/")
                        }
                        .setActionTextColor(ContextCompat.getColor((this), R.color.white))
                        .setBackgroundTint(ContextCompat.getColor((this), R.color.blue))
                        .show()
                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menu_open_wikimedia -> {
                    Snackbar.make(binding.root, "You Wanna see a Wikimedia?", Snackbar.LENGTH_LONG)
                        .setAction("See") {
                            openWebsite("https://www.wikimedia.org/")
                        }
                        .setActionTextColor(ContextCompat.getColor((this), R.color.white))
                        .setBackgroundTint(ContextCompat.getColor((this), R.color.blue))
                        .show()
                    //close drawer
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }

        firstRun()

        binding.bottomNavigationMain.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menu_explore -> {
                    replaceFragments(FragmentExplore())
                }
                R.id.menu_trend -> {
                    replaceFragments(FragmentTrend())
                }
                R.id.menu_profile -> {
                    replaceFragments(FragmentProfile())
                }
            }
            true
        }

        binding.bottomNavigationMain.setOnItemReselectedListener {}
    }

    //create function for replace fragments
    private fun replaceFragments(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.commit()
    }

    private fun firstRun() {
        replaceFragments(FragmentExplore())
        binding.bottomNavigationMain.selectedItemId = R.id.menu_explore
    }

    override fun onBackPressed() {
        super.onBackPressed()

        binding.navigationViewMain.menu.getItem(0).isChecked = false
        binding.navigationViewMain.menu.getItem(1).isChecked = false
        binding.navigationViewMain.menu.getItem(2).isChecked = false
        binding.navigationViewMain.menu.getItem(3).isChecked = false
    }

    private fun openWebsite(url: String) {
        val intentGoToWebSite = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(intentGoToWebSite)
    }
}