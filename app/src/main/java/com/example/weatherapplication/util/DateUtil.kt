package com.example.weatherapplication.util

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {
    companion object {
        val FORMAT_DD_MMMM = "dd MMMM"
        val FORMAT_HH_MM = "HH:mm"
        val FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss"

        fun getDateData(dateData: String, format: String): String {
            var date = getDateFromString(dateData)
            val dateFormat = SimpleDateFormat(format, Locale.getDefault())
            return dateFormat.format(date)
        }

        fun getDateFromString(dateString: String): Date {
            try {
                val format = SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS, Locale.getDefault())
                return format.parse(dateString)
            } catch (e: ParseException) {
                e.printStackTrace()
            }
            return Date()
        }
    }
}