package com.example.recyclercalender

import java.util.*

//locale 기기 언어 설정
open class RecyclerCalendarConfiguration(val calendarViewType: CalendarViewType, val calendarLocale: Locale, val includeMonthHeader: Boolean) {
    enum class CalendarViewType {
        VERTICAL
    }
}