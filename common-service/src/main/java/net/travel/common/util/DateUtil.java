package net.travel.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class DateUtil {
	
	public static final String DATE_ISO8601 = "yyyy-MM-dd'T'HH:mm:ssZ";
    public static final String DATE_ISO8601_V2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATE_CSV_FORMAT = "dd/MM/YYYY";
    public static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String EXPIRED_DATE_TIME = "dd-MM-yyyy HH:mm";
    public static TimeZone tzInJakarta = TimeZone.getTimeZone("Asia/Jakarta");
    public static TimeZone tzInGMT = TimeZone.getTimeZone("GMT");

    
    public static String formatDateCSV(Date date) {
        try {
            if (date == null) return "";
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_CSV_FORMAT);
            sdf.setTimeZone(tzInJakarta);
            return sdf.format(date);
        }catch (Exception e){
            return "";
        }
    }

    public static Date toDateCSV(String date) {
        try {
            return new SimpleDateFormat(DATE_CSV_FORMAT).parse(date);
        } catch (Exception e) {
          /*  System.out.println("ERROR TO DATE_CSV_FORMAT input " + date);
            System.out.println("ERROR TO DATE_CSV_FORMAT " + e.getMessage());*/
            return toDate(date);
            //return null;
        }
    }

    public static Date toDateTime(String date) {
        try {
            return new SimpleDateFormat(DATETIME_FORMAT).parse(date);
        } catch (Exception e) {
            System.out.println("ERROR TO DATE_CSV_FORMAT " + e.getMessage());
            return null;
        }
    }

    public static String expiredDateTime(Date date) {
        try {
            if (date == null) return "";
            SimpleDateFormat sdf = new SimpleDateFormat(EXPIRED_DATE_TIME);
            sdf.setTimeZone(tzInJakarta);
            return sdf.format(date);
        } catch (Exception e) {
            System.out.println("ERROR TO EXPIRED_DATE_TIME " + e.getMessage());
            return null;
        }
    }

    public static String formatDateSTD(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(tzInJakarta);
        return sdf.format(date);
    }

    public static Date toDateSTD(String date) {
        try {
            return new SimpleDateFormat(DATE_FORMAT).parse(date);
        } catch (Exception e) {
            System.out.println("ERROR TO DATE STD " + e.getMessage());
            return null;
        }
    }

    public static String formatDate(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        sdf.setTimeZone(tzInJakarta);
        return sdf.format(date);
    }

    public static String formatDateTime(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FORMAT);
        sdf.setTimeZone(tzInJakarta);
        return sdf.format(date);
    }

    public static String formatDateISO(Date date) {
        if (date == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_ISO8601);
        sdf.setTimeZone(tzInJakarta);
        return sdf.format(date);
    }

    public static Date toDate(String date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_ISO8601_V2);
            sdf.setTimeZone(tzInJakarta);
            return sdf.parse(date);
        } catch (Exception e) {
            System.out.println("ERROR TO DATE " + e.getMessage());
            return null;
        }
    }

    public static boolean isValidDate(String input) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            format.parse(input);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static Date addYear(int year, Date now){
        Calendar date = Calendar.getInstance();
        date.setTime(now);
        date.add(Calendar.YEAR,year);
        return date.getTime();
    }

    public static Date addSecond(Date date, int second) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.SECOND, second);
        cal.add(Calendar.MILLISECOND, second);
        return cal.getTime();
    }
    public static Date addMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, minutes);
        return cal.getTime();
    }

    public static Date substractMinutes(Date date, int minutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, -minutes);
        return cal.getTime();
    }

    public static Date addHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, hours);
        return cal.getTime();
    }

    public static Date substractHours(Date date, int hours) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.HOUR, -hours);
        return cal.getTime();
    }
}
