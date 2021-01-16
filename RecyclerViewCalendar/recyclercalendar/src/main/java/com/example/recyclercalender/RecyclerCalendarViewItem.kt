package com.example.recyclercalender

import java.util.*

// date of calender item

// Span size of cell for grid view
// Month Header has span size of 7 (full week)
// For offset for new month, we use empty cell which can have span from 0-6

// For offset of new month

// Header is simply a Month name cell
class RecyclerCalendarViewItem constructor(var date: Date, var spanSize: Int, var isEmpty: Boolean, var isHeader: Boolean) {
    override fun toString(): String {
        return String.format(
                Locale.getDefault(),
                "date: %s, spanSize: %d, isEmpty: %s, isHeader: %s",
                CalendarUtils.getGmt(date), spanSize, isEmpty.toString(), isHeader.toString())
    }
}