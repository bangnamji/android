package com.example.viewbinding

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class FragmentOne:Fragment() {

    override fun onAttach(context: Context) {
        Log.d("Life-Cycle", "onAttach")
        super.onAttach(context)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("Life-Cycle", "onCreateView")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life-Cycle", "onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life-Cycle", "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d("Life-Cycle", "onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d("Life-Cycle", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d("Life-Cycle", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d("Life-Cycle", "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d("Life-Cycle", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDetach() {
        Log.d("Life-Cycle", "onDetach")
        super.onDetach()
    }
}
