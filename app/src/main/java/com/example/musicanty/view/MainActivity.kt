package com.example.musicanty.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.musicanty.R
import com.example.musicanty.databinding.ActivityMainBinding

import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private lateinit var bindging: ActivityMainBinding
    private lateinit var musicFragment: MusicPlayFragment
    private lateinit var albumFragment: AlbumFragment
    private var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindging.root)

        musicFragment = MusicPlayFragment()
        albumFragment = AlbumFragment()

        bindging.apply {
            mainBottomNav.setOnItemSelectedListener(this@MainActivity)
            mainBottomNav.selectedItemId = R.id.play_music_menu
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.play_music_menu -> {
                if (currentFragment == musicFragment) return false
                currentFragment = musicFragment
            }
            R.id.album_menu -> {
                if (currentFragment == albumFragment) return false
                currentFragment = albumFragment
            }
        }

        currentFragment?.let {
            replaceFragment(R.id.main_fragment, it)
        }

        return true
    }

    private fun replaceFragment(mainFragment: Int, fragment: Fragment) {

        if (supportFragmentManager.findFragmentById(mainFragment) == null) {
            supportFragmentManager.beginTransaction().apply {
                add(mainFragment, fragment)
                commit()
            }
        } else {
            supportFragmentManager.beginTransaction().apply {
                replace(mainFragment, fragment)
                addToBackStack(null)
                commit()
            }
        }

    }

}
