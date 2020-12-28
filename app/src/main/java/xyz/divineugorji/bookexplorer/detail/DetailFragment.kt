package xyz.divineugorji.bookexplorer.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import xyz.divineugorji.bookexplorer.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(activity).application
        // Inflate the layout for this fragment
       val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

}