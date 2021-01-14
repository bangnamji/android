package com.example.recyclercalendar.views

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclercalendar.adapter.SimpleRecyclerCalendarAdapter
import com.example.recyclercalendar.model.SimpleRecyclerCalendarConfiguration
import java.util.*

class SimpleRecyclerCalendarView : RecyclerView {

    private var configuration: SimpleRecyclerCalendarConfiguration? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    fun initialise(
        startDate: Date,
        endDate: Date,
        configuration: SimpleRecyclerCalendarConfiguration,
        dateSelectListener: SimpleRecyclerCalendarAdapter.OnDateSelected
    ) {
        this.configuration = configuration

        val simpleRecyclerCalendarView: SimpleRecyclerCalendarAdapter =
            SimpleRecyclerCalendarAdapter(
                startDate = startDate,
                endDate = endDate,
                configuration = configuration,
                dateSelectListener = dateSelectListener
            )

        adapter = simpleRecyclerCalendarView
    }

    fun getConfiguration(): SimpleRecyclerCalendarConfiguration? {
        return configuration
    }
}