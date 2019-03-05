import java.lang.Exception
import java.time.DayOfWeek
import java.time.Month
import java.time.MonthDay
import java.time.Year
import java.util.*
import kotlin.concurrent.fixedRateTimer

fun main(args: Array<String>) {


//    age().date.also(::println)


    println("enter your year")
    try {val year:Int?= readLine()!!.toInt();age().getyear(year)}catch (er:Exception){print("!!!")}
    println("enter your month")
    try {val month:Int?= readLine()!!.toInt();age().getyear(month)}catch (er:Exception){print("!!!")}
    println("enter your day")
    try {val day:Int?= readLine()!!.toInt();age().getyear(day)}catch (er:Exception){print("!!!")}
    println("enter your hour")
    try {val hour:Int?= readLine()!!.toInt();age().getyear(hour)}catch (er:Exception){print("!!!")}
    println("enter your minute")
    try {val minute:Int?= readLine()!!.toInt();age().getyear(minute)}catch (er:Exception){print("!!!")}

}

@Suppress("UNUSED_EXPRESSION")
private class age {
    val date=Date()
    val year=Year.now().toString().toInt()
    val months=MonthDay.now().monthValue
    val month=MonthDay.now().monthValue-1 ;val max=Month.of(month).maxLength()
    val february=Month.FEBRUARY.maxLength()-1 // february is unque ....
    val day=MonthDay.now().dayOfMonth
    val hour=Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    val minute=Calendar.getInstance().get(Calendar.MINUTE)

    internal fun getyear(myear: Int?)= if (myear!! !in 0..year){
            "out!!".also(::print)
        }else{"${(year-myear)-1}\t".also(::print)}
    internal fun getmonth(mmonth: Int?):Int{ val mo=mmonth
        if (mo!! !in 1..12){"(out!!)".also(::print)}
        else if (mo<months){"${months-mo}\t".also(::print)
        }else if (mo>months){"${12-(mo-months)}\t".also(::print)
        } else {"${0}\t".also(::print)}
        return mo }
    internal fun getday(mday: Int?):Int{ val md=mday
        if (md!! !in 1..31){"(out!!)".also(::print)}
        else if (md<day){"${day-md}".also(::print)
        }else if (months==3){"${(february-md)+day}\t".also(::print)
        }else if (md>day){"${(max-md)+day}\t".also(::print)
        }else{"${0}\t".also(::print) }
        return md }
    internal fun gethour(mhour:Int?):Int {
        val mh = mhour
        if (mh!! !in 0..24){"(out!!)".also(::print)}
        else if (mh < hour) {"${hour - mh}\t".also(::print)
        } else if (mh > hour) {"${24 - (mh - hour)}\t".also(::print)
        } else {"${0}\t".also(::print) }
        return mh}
    internal fun getminute(mminute:Int?):Int{
        val mi=mminute
        if (mi!! !in 0..60){"out!!".also(::print)}
        else if (mi<minute){"${minute-mi}\t".also(::print)
        }else if (mi>minute){"${60-(mi-minute)}\t".also(::print)
        }else{"${0}"}
        return mi}
}


