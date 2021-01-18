package com.example.project.dmh_study.simple

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import com.example.project.R
import com.example.recyclercalendar.adapter.InfiniteRecyclerCalendarAdapter
import com.example.recyclercalendar.model.InfiniteRecyclerCalendarConfiguration
import com.example.recyclercalendar.model.RecyclerCalendarConfiguration
import com.example.recyclercalendar.utilities.CalendarUtils
import com.example.recyclercalendar.views.InfiniteRecyclerCalendarView
import java.util.*

class InfiniteRecyclerCalendarActivity : AppCompatActivity() {

    private var calenderView: InfiniteRecyclerCalendarView? = null
    private var selectionMode: InfiniteRecyclerCalendarConfiguration.SelectionMode? = null
    private var calendarViewType: RecyclerCalendarConfiguration.CalenderViewType =
        RecyclerCalendarConfiguration.CalenderViewType.VERTICAL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_infinite_recycler_calender)

        calenderView = findViewById(R.id.calendarRecyclerView)

        val date = Date()
        date.time = System.currentTimeMillis()

        val startCal = Calendar.getInstance()

        val endCal = Calendar.getInstance()
        endCal.time = date
        endCal.add(Calendar.MONTH, 3)

//        val buttonSetting: ImageButton = findViewById(R.id.buttonSimpleSettings)
        val layoutSettingContainer: LinearLayout = findViewById(R.id.layoutSettingContainer)

//        buttonSetting.setOnClickListener {
//            if (layoutSettingContainer.visibility == View.VISIBLE) {
//                layoutSettingContainer.visibility = View.GONE
//            } else {
//                layoutSettingContainer.visibility = View.VISIBLE
//            }
//        }

        val radioViewTypeVertical: RadioButton = findViewById(R.id.radioViewTypeVertical)
//        val radioViewTypeHorizontal: RadioButton = findViewById(R.id.radioViewTypeHorizontal)

        radioViewTypeVertical.setOnClickListener {
            // Switch to Vertical View
            calendarViewType = RecyclerCalendarConfiguration.CalenderViewType.VERTICAL

            refreshCalendarCalendar(
                startDate = startCal.time,
                endDate = endCal.time
            )
        }

//        radioViewTypeHorizontal.setOnClickListener {
//            // Switch to Horizontal View
//            calendarViewType = RecyclerCalendarConfiguration.CalenderViewType.HORIZONTAL
//
//            refreshCalendarCalendar(
//                startDate = startCal.time,
//                endDate = endCal.time
//            )
//        }

        selectionMode = InfiniteRecyclerCalendarConfiguration.SelectionModeNone()

        refreshCalendarCalendar(
            startDate = startCal.time,
            endDate = endCal.time

        )
    }

    private fun refreshCalendarCalendar(
        startDate: Date,
        endDate: Date
    ) {
        if (calenderView == null || selectionMode == null) {
            return
        }
        val configuration: InfiniteRecyclerCalendarConfiguration =
            InfiniteRecyclerCalendarConfiguration(
                calenderViewType = calendarViewType,
                calendarLocale = Locale.getDefault(),
                includeMonthHeader = true,
                selectionMode = selectionMode!!
            )

        calenderView!!.initialise(
            configuration,
            object : InfiniteRecyclerCalendarAdapter.OnDateSelected {
                override fun onDateSelected(date: Date) {
                    Toast.makeText(
                        calenderView!!.context,
                        "Date Selected: ${CalendarUtils.getGmt(date)}",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })
    }
}