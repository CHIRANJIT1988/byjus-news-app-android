package com.byjus.news.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.inject.Inject;
import javax.inject.Named;

public class DateUtils {

    @Inject
    @Named("yyyy-MM-dd'T'HH:mm:ss")
    SimpleDateFormat sdf_yyyy_MM_dd_HH_mm_ss;

    @Inject
    @Named("yyyy-MM-dd")
    SimpleDateFormat sdf_yyyy_MM_dd;

    @Inject
    public DateUtils() {

    }

    public String getPublishedDate(String publishedAt) {
        sdf_yyyy_MM_dd_HH_mm_ss.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            Date date = sdf_yyyy_MM_dd_HH_mm_ss.parse(publishedAt);
            return sdf_yyyy_MM_dd.format(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return "";
    }
}
