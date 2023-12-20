package com.javaclimb.drug.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 处理日期相关的操作
 */
public class DateUtil {

    /**
     * 把日期格式转换成年月日(yyyy-MM-dd)的字符串
     */
    public static String dateConvert(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public static String parseToPatten(String inputPatten, String outputPatten,String inputDate)  {
        SimpleDateFormat inputFormat=new SimpleDateFormat(inputPatten);
        SimpleDateFormat outputFormat=new SimpleDateFormat(outputPatten);
        try {
            Date date = inputFormat.parse(inputDate);
            String formattedDate = outputFormat.format(date);
            return formattedDate;
        } catch (ParseException e) {
            e.printStackTrace();
            return null; // 或者返回一个默认值，表示解析失败
        }
    }
    public static String parseToPatten(String patten,Date inputDate){
        SimpleDateFormat outputFormat=new SimpleDateFormat(patten);
        String formattedDate = outputFormat.format(inputDate);
        return formattedDate;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.dateConvert(new Date()));
    }
}
