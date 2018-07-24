package greenbookapi.util

import java.text.DateFormat
import java.text.SimpleDateFormat

class FormatUtil {

    static String stripSpecialCharacters (String input) {
        input = input.replace('\\', '')
        input = input.replace('\0', '')
        input = input.replace('\'', '')
        input = input.replace('\"', '')
        input = input.replace('\b', '')
        input = input.replace('\n', '')
        input = input.replace('\r', '')
        input = input.replace('\t', '')
        input = input.replace('%', '')
        input = input.replace('_', '')
        input
    }

    static String convertDateToString(Date d) {
        String sDate
        DateFormat formatter = new SimpleDateFormat('yyyy-MM-dd')
        sDate = formatter.format(d)
        sDate
    }

    static Date convertStringToDate(String date) {
        DateFormat formatter = new SimpleDateFormat('yyyy-MM-dd')
        Date dDate = (Date) formatter.parse(date)
        dDate
    }

    static String extractTimeFromDate (Date d) {
        String sDate
        DateFormat formatter = new SimpleDateFormat('hh:mm:ss')
        sDate = formatter.format(d)
        sDate
    }


}
