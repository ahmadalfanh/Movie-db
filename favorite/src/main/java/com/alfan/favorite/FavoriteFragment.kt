package com.alfan.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.alfan.core.domain.model.Movie
import androidx.navigation.fragment.findNavController
import com.alfan.core.ui.MovieAdapter
import com.alfan.di.ViewModelFactory
import com.alfan.moviedb.di.FavoriteModuleDependencies
import com.alfan.favorite.databinding.FragmentFavoriteBinding
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteFragment : Fragment() {
    @Inject
    lateinit var factory: ViewModelFactory

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    private var binding: FragmentFavoriteBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder().context(requireContext()).appDependencies(
            EntryPointAccessors.fromApplication(
                requireContext().applicationContext, FavoriteModuleDependencies::class.java
            )
        ).build().inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding?.root!!
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MovieAdapter()

        viewModel.favorite.observe(viewLifecycleOwner) {
            adapter.setMovieList(it)
            binding?.apply {
                rvMovie.setHasFixedSize(true)
                rvMovie.adapter = adapter
            }
        }


        adapter.setOnItemClickCallback(object : MovieAdapter.OnItemClickCallback {
            override fun onItemClick(movie: Movie) {
                val movie = Movie(
                    movie.id,
                    movie.overview,
                    movie.poster_path,
                    movie.original_title
                )
                val action = FavoriteFragmentDirections.actionNavFavoriteToNavDetails(movie)
                findNavController().navigate(action)
            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding?.rvMovie?.adapter = null
        binding = null
    }
}