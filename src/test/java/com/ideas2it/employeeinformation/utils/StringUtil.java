package com.ideas2it.employeeinformation.utils;

import java.lang.StringBuilder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ideas2it.employeeinformation.commons.constants.Constants;

/**
 * The StringUtil Utility class contains the EmailId and Alphabet Validation
 * for the String datatypes.
 * This method uses the Regex class for validating the EmailID
 * and Alphabet validation.
 *
 * @author    Arul Murugan
 * @version   1.0
 */
public final class StringUtil {

    private StringUtil() {
    }

    /**
     * <p>
     * This Method is used to validate whether the string given by the user
     * contains only Alphabets. Pattern and matches are used to check the
     * string given by the user.
     * </p>
     *
     * @param  checkAlphabet  String datatype contains the value given by the
     *                        user.
     * @return  boolean  returns true when String contains only Alphabets
     *                   and false when it contains other than Alphabets.
     */
    public static boolean validateAlphabet(final String checkAlphabet) {
        if (null == checkAlphabet) {
            return Boolean.FALSE;
        }
        return Pattern.matches(Constants.ALPHABET_VALIDATOR,checkAlphabet);
    }

    /**
     * <p>
     * This Method is used to validate whether the Emailid given by the user
     * is in correct Format.
     * </p>
     * Ex: if the given EmailId is in correct format returns true and if it is
     * invalid then it returns false.
     *
     * @param  emailId  String datatype contains the EmailId given by the user.
     * @return boolean  returns true when EmailId is valid and false when
     *                  not valid
     */
    public static boolean validateEmail(final String emailId) {
        if(null == emailId) {
            return Boolean.FALSE;
        }
        return Pattern.matches(GET_EMAILID_FORMAT(),emailId);
    }

    /**
     * <p>
     * This Method is used to Get the JDBC url for the connection to the
     * database of the MySql Server.
     * </p>
     *
     * @return url An string datatype contains the url by which it gets JDBC
     *                       connection for the database.
     */
    public static final String GET_JDBC_URL() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("jdbc:mysql://localhost:3306/");
        stringBuilder.append(Constants.DATABASE_NAME);
        stringBuilder.append("?useSSL=false");
        String url = stringBuilder.toString();
        stringBuilder.delete(0,stringBuilder.length());
        return url;
    }

    /**
     * <p>
     * This Method is used to get the EmailId format for the validating the
     * given EmailId by the user.
     * </p>
     *
     * @return emailIdFormat An string datatype contains the Format of an Email
     *                       which is used to validate.
     */
    public static final String GET_EMAILID_FORMAT() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("^[a-z0-9.-_]+@+[a-z0-9]+\\.+[a-z]{2,5}$");
        String emailIdFormat = stringBuilder.toString();
        stringBuilder.delete(0,stringBuilder.length());
        return emailIdFormat;
    }
}
