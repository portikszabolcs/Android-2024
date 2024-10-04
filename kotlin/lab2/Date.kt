package lab2

data class Date(var year: Int, var month: Int, var day: Int) : Comparable<Date> {
    override fun compareTo(other: Date): Int {
        if(year != other.year) return year - other.year
        if(month != other.month) return month - other.month
        return day - other.day
    }
}

fun Date.leapYear(): Boolean {
    if(year.toDouble() % 4 != 0.0) return false
    if(year.toDouble() % 100 != 0.0) return true
    return year.toDouble() % 400 == 0.0
}

fun Date.isValid(): Boolean {
    if (year < 1 || month < 1 || day < 1) return false
    if (month > 12 || day > 31) return false
    if (month < 7 && month % 2 == 0 && day > 30) return false
    if (month > 7 && month % 2 == 1 && day > 30) return false
    return !(month == 2 && ((leapYear() && day > 29) || (!leapYear() && day > 28)))
}
