package com.example.androidapp.tablayoutdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.androidapp.R
import com.example.androidapp.databinding.FragmentCrownBinding


class CrownFragment : Fragment() {

    private var binding: FragmentCrownBinding? = null
    private lateinit var backpackList : ArrayList<Backpack>
    private lateinit var backpackAdapter : BackpackAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentCrownBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        binding?.crownRV?.setHasFixedSize(true)
        binding?.crownRV?.layoutManager = GridLayoutManager(requireContext(), 2)

        backpackList = ArrayList()

        backpackList.add(Backpack(R.drawable.hivecrown, "Fleet", "Valid Until", "30 Feb 2023 15:25"))
        backpackList.add(Backpack(R.drawable.hivecrown, "Love Train", "Valid Until", "30 Jan 2023 15:25"))
        backpackList.add(Backpack(R.drawable.hivecrown, "Airplane", "Valid Until", "30 Mar 2023 15:25"))
        backpackList.add(Backpack(R.drawable.hivecrown, "Fleet", "Valid Until", "30 Apr 2023 15:25"))
        backpackList.add(Backpack(R.drawable.hivecrown, "Love Train", "Valid Until", "30 May 2023 15:25"))
        backpackList.add(Backpack(R.drawable.hivecrown, "Airplane", "Valid Until", "30 Jun 2023 15:25"))

        backpackAdapter = BackpackAdapter(backpackList)
        binding?.crownRV?.adapter = backpackAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}