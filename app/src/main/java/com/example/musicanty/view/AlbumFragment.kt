package com.example.musicanty.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.musicanty.R
import com.example.musicanty.databinding.FragmentAlbumBinding

class AlbumFragment: Fragment(R.layout.fragment_album) {

    private var binding: FragmentAlbumBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAlbumBinding.bind(view)


    }
    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}