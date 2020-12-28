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

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: HomeViewModel by lazy {
        ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
         binding = FragmentHomeBinding.inflate(inflater)

        binding.viewModel = viewModel

        // Allows Data Binding to Observe LiveData with the lifecycle of this Fragment
        binding.lifecycleOwner = this

        binding.photosGrid.adapter = HomeGridAdapter()


        return binding.root

    }

}