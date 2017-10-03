package utils

import java.util.{Calendar, Date}

/**
  * Created by skatta on 10/2/2017 AD.
  */
object Helpers {

  def getLastWeekDateRange: (Date, Date) ={
    val calendar = Calendar.getInstance()
    val i = calendar.get(Calendar.DAY_OF_WEEK) - calendar.getFirstDayOfWeek
    calendar.add(Calendar.DATE, -i - 7)
    val start = calendar.getTime
    calendar.add(Calendar.DATE, 7)
    val end = calendar.getTime
    (start, end)
  }

  def getLastMonthDateRange: (Date, Date) ={
    val calendar = Calendar.getInstance()
    calendar.add(Calendar.MONTH, -1)
    calendar.set(Calendar.DATE, 1)
    val start = calendar.getTime
    calendar.set(Calendar.DATE, calendar.getActualMaximum(Calendar.DAY_OF_MONTH))
    val end = calendar.getTime
    (start, end)
  }

  def round(x:Double):Double= BigDecimal(x).setScale(2, BigDecimal.RoundingMode.HALF_UP).toDouble

  def dateSubtractDays(date: Date, days:Int):Date={
    val dateAux = Calendar.getInstance()
    dateAux.setTime(date)
    dateAux.add(Calendar.DATE, -days)
    dateAux.getTime
  }
}