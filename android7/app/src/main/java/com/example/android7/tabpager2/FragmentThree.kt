package com.example.android7.tabpager2

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android7.R


class FragmentThree : Fragment() {
    override fun onAttach(context: Context) {
        Log.d("Life-cycle","onAttach")
        super.onAttach(context)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onCreate")
        super.onCreate(savedInstanceState)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onViewCreated")
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragmentthree,container,false)
        // 밑의 fragment_one이라는 xml에서 그려진 걸 fragment에 그린다.
        Log.d("Life-cycle","onCreateView")

    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d("Life-cycle","onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }
    override fun onStart() {
        Log.d("Life-cycle","onStart")
        super.onStart()
    }
    override fun onResume() {
        Log.d("Life-cycle","onResume")
        super.onResume()
    }
    override fun onPause() {
        Log.d("Life-cycle","onPause")
        super.onPause()
    }
    override fun onStop() {
        Log.d("Life-cycle", "onStop")
        super.onStop()
    }
    override fun onDestroyView() {
        Log.d("Life-cycle","onDestroyView")
        super.onDestroyView()
    }
    override fun onDetach() {
        Log.d("Life-cycle","onDetach")
        super.onDetach()
    }
}