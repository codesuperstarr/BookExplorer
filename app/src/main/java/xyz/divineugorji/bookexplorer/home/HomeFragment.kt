package xyz.divineugorji.bookexplorer.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import xyz.divineugorji.bookexplorer.R
import xyz.divineugorji.bookexplorer.databinding.FragmentHomeBinding
import xyz.divineugorji.bookexplorer.databinding.GridViewBinding


class HomeFragment : Fragment() {

    private lateinit var binding: GridViewBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
         binding = GridViewBinding.inflate(inflater)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        return binding.root


    }

}