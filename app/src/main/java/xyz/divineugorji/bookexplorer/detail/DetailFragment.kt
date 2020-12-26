package xyz.divineugorji.bookexplorer.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import xyz.divineugorji.bookexplorer.R
import xyz.divineugorji.bookexplorer.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detail, container, false)
        binding.lifecycleOwner = this
        return binding.root
    }

}