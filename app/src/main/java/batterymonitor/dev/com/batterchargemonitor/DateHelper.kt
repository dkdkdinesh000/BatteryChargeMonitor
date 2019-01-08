package batterymonitor.dev.com.batterchargemonitor
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateHelper {

    fun getDateWithServerTimeStamp(str: String): Date? {
        val dateFormat = SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            Locale.getDefault()
        )
        dateFormat.timeZone = TimeZone.getDefault() // IMP !!!
        try {
            return dateFormat.parse(str)
        } catch (e: ParseException) {
            return null
        }
    }

    fun getDateStr(date: Date): String? {
        val dateFormat = SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss",
            Locale.getDefault()
        )
        dateFormat.timeZone = TimeZone.getDefault() // IMP !!!
        try {
            return dateFormat.format(date)
        } catch (e: ParseException) {
            return null
        }
    }
}

