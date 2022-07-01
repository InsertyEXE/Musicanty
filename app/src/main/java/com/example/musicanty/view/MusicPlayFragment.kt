package com.example.musicanty.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.musicanty.R
import com.example.musicanty.databinding.FragmentMusicBinding

class MusicPlayFragment: Fragment(R.layout.fragment_music) {

    private var binding: FragmentMusicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMusicBinding.bind(view)

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}