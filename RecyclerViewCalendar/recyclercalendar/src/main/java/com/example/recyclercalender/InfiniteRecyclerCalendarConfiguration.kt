package com.example.recyclercalender

import java.util.*

class InfiniteRecyclerCalendarConfiguration(
        calenderViewType: CalendarViewType,
        calendarLocale: Locale,
        includeMonthHeader: Boolean,
        selectionMode: SelectionMode
) : RecyclerCalendarConfiguration(
        calenderViewType, calendarLocale, includeMonthHeader
) {
    var selectionMode: SelectionMode = SelectionModeNone()

    init {
        this.selectionMode = selectionMode
    }

    //selectionmode 선택된 날짜가 없다!
    open class SelectionMode {
        enum class TYPE {
            NONE
        }

        var selectionType: TYPE = TYPE.NONE
    }

    class SelectionModeNone : SelectionMode() {
        init {
            this.selectionType = TYPE.NONE
        }
    }

}