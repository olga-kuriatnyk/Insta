package com.example.insta

import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.core.content.FileProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.insta.fragments.ComposeFragment
import com.example.insta.fragments.ExitFragment
import com.example.insta.fragments.HomeFragment
import com.example.insta.fragments.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.parse.*
import java.io.File

/*
 * Let user create a post by taking a photo with their camera
 */

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager: FragmentManager = supportFragmentManager



        findViewById<BottomNavigationView>(R.id.bottom_navigation).setOnItemSelectedListener {
            item ->

            var fragmentToShow: Fragment? = null
            when (item.itemId) {
                // home item
                R.id.action_home -> {


                   fragmentToShow = HomeFragment()
                }

                // compose item
                R.id.action_compose -> {
                    fragmentToShow = ComposeFragment()
                }

                // profile item
                R.id.action_profile -> {
                    fragmentToShow = ProfileFragment()
                }

                // exit item
                R.id.action_exit -> {
                    fragmentToShow = ExitFragment()
                }
            }

            if (fragmentToShow != null) {
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragmentToShow).commit()
            }


            // return true to day that we've handled this user interaction on the item
            true
        }

        // Set default selection
        findViewById<BottomNavigationView>(R.id.bottom_navigation).selectedItemId = R.id.action_home

//        queryPosts()
    }



    companion object {
        val TAG = "MainActivity"
    }
}