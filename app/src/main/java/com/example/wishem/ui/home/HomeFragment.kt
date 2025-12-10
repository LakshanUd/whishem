package com.example.wishem.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.wishem.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set header values (you can bind these from a ViewModel if you like)
        binding.tvWelcome.text = getString(com.example.wishem.R.string.welcome)
        binding.tvUserName.text = getString(com.example.wishem.R.string.user_name_sample)
        binding.tvBigDate.text = getString(com.example.wishem.R.string.big_date_sample)

        // Default: both sections expanded
        binding.todayList.visibility = View.VISIBLE
        binding.upcomingList.visibility = View.VISIBLE

        // Toggle Today’s Birthdays
        binding.btnToggleToday.setOnClickListener {
            val visible = binding.todayList.visibility == View.VISIBLE
            binding.todayList.visibility = if (visible) View.GONE else View.VISIBLE
            binding.btnToggleToday.setImageResource(
                if (visible) com.example.wishem.R.drawable.ic_expand_more
                else com.example.wishem.R.drawable.ic_expand_less
            )
        }

        // Toggle Upcoming Birthdays
        binding.btnToggleUpcoming.setOnClickListener {
            val visible = binding.upcomingList.visibility == View.VISIBLE
            binding.upcomingList.visibility = if (visible) View.GONE else View.VISIBLE
            binding.btnToggleUpcoming.setImageResource(
                if (visible) com.example.wishem.R.drawable.ic_expand_more
                else com.example.wishem.R.drawable.ic_expand_less
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
