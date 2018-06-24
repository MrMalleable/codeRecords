package com.ilovewl.javaeeblog;

import com.ilovewl.javaeeblog.utils.DateUtils;

import java.text.ParseException;
import java.util.Date;

/**
 * test the dateutils class
 *
 * @author MrBread
 * @date 2018-06-24-9:15
 **/

public class TestDateUtils {
    public static void main(String a[]){
        try {
            System.out.println(DateUtils.getDate("2018-06-2409:18:11").toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
