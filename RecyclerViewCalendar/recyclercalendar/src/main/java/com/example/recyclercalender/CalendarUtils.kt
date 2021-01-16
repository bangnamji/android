package com.example.recyclercalender

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class CalendarUtils {

    //companion object는 어떤 클래스의 모든 인스턴스가 공유하는 객체를 만들고 싶을 때 사용
    // 단, 클래스당 한 개씩만 사용 가능
    companion object {
        @JvmStatic
        val DB_DATE_FORMAT = "yyyyMMdd"
        @JvmStatic
        val DB_YEAR_MONTH_FORMAT = "yyyyMM"
        @JvmStatic
        val LONG_DATE_FORMAT = "EEE, dd MMM yyyy"
        @JvmStatic
        val LONG_DATE_DAY = "E"
        @JvmStatic
        val DISPLAY_WEEK_DAY_FORMAT = "EEEEEE"
        @JvmStatic
        val DISPLAY_MONTH_FORMAT = "MMMM"
        @JvmStatic
        val DISPLAY_DATE_FORMAT = "dd"

        @JvmStatic
        fun dateFromAnyFormat(locale: Locale, date: String, format: String): Date?{
            //예외처리
            //try에서 실행한 코드 오류 -> catch에서 오류 처리
            return try {
                val formatter = SimpleDateFormat(format,locale)     //SimpleDateFormat를 사용하여 현재 날짜 출력
                formatter.parse(date)
            } catch (e: ParseException) {
                e.printStackTrace()
                null
            }
        }

        @JvmStatic
        fun dateStringFromFormat(locale: Locale = Locale.getDefault(), date: Date, format: String): String? {
            return try {
                val formatter =
                        SimpleDateFormat(format, locale)
                formatter.format(date)
            } catch (e: Exception) {
                e.printStackTrace()
                null
            }
        }

        @JvmStatic
        fun getGmt(date: Date): String {
            val dfDate = SimpleDateFormat("dd/MMM/yyyy HH:mm:ss", Locale.getDefault())
            return dfDate.format(date.time)
        }
    }
}