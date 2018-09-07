package com.ideas2it.employeeinformation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ideas2it.employeeinformation.commons.constants.Constants;

/**
 * <p>
 * The DateUtil class contains the calculateDateDifference method used to
 * calculate the difference between the given date by the user and the current
 * date which is used by other classes.
 * </p>
 * <p>
 * This class also contains method to convert the date as a String format and
 * Date validation method by which the date given by user is validated.
 * </p>
 * The methods available in this class are :
 * <ul>
 * <li> calculateDateDifference </li>
 * </ul>
 * @author    Arul Murugan
 * @version   1.0
 */
public final class DateUtil {

    private DateUtil() {
    }

    /**
     * <p>
     * This Method is used to calculate the difference between the given Date by
     * the user and the current Date.It uses the Calendar Class and gets the
     * instance from which current date is fetched and difference is calculated.
     * </p>
     * It returns the difference value as an Integer Datatype.
     *
     * @param  date Date datatype contains a Date given by the user.
     * @return  datatype contains the calculated age of the person.
     */
    public static Integer calculateDateDifference(final Date date) {

        Integer dateDifference = 0;
        Calendar birthYear = new GregorianCalendar();
        Calendar currentYear = Calendar.getInstance();
        birthYear.setTime(date);

        if(birthYear.get(Calendar.DAY_OF_YEAR) <
            currentYear.get(Calendar.DAY_OF_YEAR)) {
            dateDifference = 0;
        }
        dateDifference = currentYear.get(Calendar.YEAR) -
                birthYear.get(Calendar.YEAR);
        return dateDifference;
    }
}
