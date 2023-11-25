package com.example.danhba_fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ListView
import androidx.navigation.fragment.findNavController


val items_name: Array<String> = arrayOf("HUST", "CTSV", "Le Ba Vui", "Tuto.com", "support")

val items = arrayListOf<ItemModel>()
class ListFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listView = view.findViewById<ListView>(R.id.list_view)
        var buttonAdd = view.findViewById<Button>(R.id.button)

        repeat(items_name.size) {
            val index = it + 1
            val userAtIndex = items_name[it]
            items.add(ItemModel(
                "$userAtIndex",
                resources.getIdentifier("thumb$index", "drawable", requireContext().packageName)
            ))
        }

        listView.adapter = ItemAdapter(items)

        listView.setOnItemClickListener { parent, view, position, id ->
            val index = position
            val bundle = Bundle()
            bundle.putInt("INDEX", position) // Truyền index vào bundle
            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
        buttonAdd.setOnClickListener {
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        }

    }

}