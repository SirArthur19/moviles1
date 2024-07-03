package com.cibertec.cibertecapp.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cibertec.cibertecapp.R

class LugarFragment:Fragment() {

    private lateinit var viewModel: LugarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lugar, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[LugarViewModel::class.java]

        val recyclerLugar = view.findViewById<RecyclerView>(R.id.recyclerPlace)
        val adapter = LugarAdapter()
        recyclerLugar.adapter = adapter
        recyclerLugar.layoutManager = LinearLayoutManager(activity)

        viewModel.getLugar()
        viewModel.lugarListMutable.observe(viewLifecycleOwner){
            if (it.isNotEmpty()){
                adapter.setLugar(it)
            }
        }

        //

    }

    companion object{
        fun newInstance() : LugarFragment = LugarFragment()
    }
}