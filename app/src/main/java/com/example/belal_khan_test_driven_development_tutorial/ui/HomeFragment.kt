package net.simplifiedcoding.spendtracker.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.belal_khan_test_driven_development_tutorial.R
import com.example.belal_khan_test_driven_development_tutorial.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val spendsAdapter = SpendsAdapter()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.recyclerViewSpends.also {
            it.layoutManager = LinearLayoutManager(requireContext())
            it.setHasFixedSize(true)
            it.adapter = spendsAdapter
        }

        binding.buttonAddSpend.setOnClickListener {
            findNavController().navigate(R.id.addSpendFragment)
        }

        viewModel.last20SpendsLiveData.observe(viewLifecycleOwner) { spends ->
            spendsAdapter.spends = spends
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getLast20Spends()
    }
}