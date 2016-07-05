/**
 * 日期时间工具类
 * 
 * @author liuchunbo liuchunbo@metersbonwe.com
 * @date 2015年1月22日 下午1:55:41
 * @since V1.0
 * @version V1.0
 */


import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 日期时间工具类
 */
public class DateUtil {
    
    /**
     * 获取现在时间
     * 
     * @return 返回时间类型 yyyy-MM-dd HH:mm:ss
     */
    public static Date getNowDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     * 
     * @return返回短时间格式 yyyy-MM-dd
     */
    public static Date getNowDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        ParsePosition pos = new ParsePosition(0);
        Date currentTime_2 = formatter.parse(dateString, pos);
        return currentTime_2;
    }

    /**
     * 获取现在时间
     * 
     * @return返回字符串格式 yyyy-MM-dd HH:mm:ss
     */
    public static String getStringDate() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
    
    /**
     * 获取现在时间
     * 
     * @return返回字符串格式 yyyyMMddHHmmss
     */
    public static String getStringDateForDigital() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 获取现在时间
     * 
     * @return 返回短时间字符串格式yyyy-MM-dd
     */
    public static String getStringDateShort() {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        return dateString;
    }
   /**
    * 获取现在时间
    * 
    * @return 返回短时间字符串格式yyyy-MM-dd
    */
   public static String getStringDateShort(String format) {
       Date currentTime = new Date();
       SimpleDateFormat formatter = new SimpleDateFormat(format);
       String dateString = formatter.format(currentTime);
       return dateString;
   }

    /**
     * 获取时间 小时:分;秒 HH:mm:ss
     * 
     * @return
     */
    public static String getTimeShort() {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date currentTime = new Date();
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    /**
     * 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm:ss
     * 
     * @param strDate
     * @return
     */
    public static Date strToDateLong(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
     * 
     * @param dateDate
     * @return
     */
    public static String dateToStrLong(Date dateDate) {
        if(dateDate==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将日期毫秒数转换为字符串 yyyy-MM-dd HH:mm:ss
     * 
     * @param millis
     * @return 毫秒数
     */
    public static String millisToStrLong(long millis) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(new Date(millis));
        return dateString;
    }

    /**
     * 将短时间格式时间转换为字符串 yyyy-MM-dd
     * 
     * @param dateDate
     * @param k
     * @return
     */
    public static String dateToStr(Date dateDate) {
        if(dateDate==null){
            return null;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(dateDate);
        return dateString;
    }

    /**
     * 将短时间格式字符串转换为时间 yyyy-MM-dd
     * 
     * @param strDate
     * @return
     */
    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    /**
     * 比较开始时间和结束时间大小
     * 
     * @param beginDate
     * @param endDate
     * @return true 开始时间小于等于结束时间
     */
    public static boolean compare(Date beginDate, Date endDate) {
        boolean result = false;
        if (beginDate != null && endDate != null
                && (beginDate.getTime() <= endDate.getTime())) {
            result = true;
        }
        return result;
    }

    /**
     * 判断日期是否符合指定年度和月份 (例如:2007, 7 , 20007-07-07)
     * 
     * @param year
     * @param month
     * @param date
     * @return true:
     */
    public static boolean isConfirmYearAndMonth(String year, String month,
            Date date) {
        boolean result = false;
        if (year==null||year=="" ||month==null||month==""
                || null == date) {
            return result;
        }
        String str = dateToStr(date);
        String[] patten = str.split("-");

        if (null == patten || patten.length != 3) {
            return result;
        }

        String cmonth = String.valueOf(Integer.valueOf(patten[1]));

        if (year.equals(patten[0]) && month.equals(cmonth)) {
            result = true;
        }
        return result;
    }

    /**
     * 功能描述： 判断指定时间段是否有重叠 开始和结束时间已经部分有序
     * 
     * @param startDate1
     *            开始时间1
     * @param endDate1
     *            结束时间1
     * @param startDate2
     *            开始时间2
     * @param endDate2
     *            结束时间2
     * @return
     */
    public static boolean compareTimePeriod(Date startDate1, Date endDate1,
            Date startDate2, Date endDate2) {
        if (null == startDate1 || null == endDate1 || null == startDate2
                || null == endDate2) {
            return false;
        }
        if ((startDate1.getTime() > endDate2.getTime())
                || startDate2.getTime() > endDate1.getTime()) {
            return true;
        }

        return false;
    }

    /**
     * 功能描述： 获取与指定日期相差天数的日期
     * 
     * @param days
     *            当前日期差额
     * @return
     */
    public static Date getNextTargetDay(Date date, int days) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    public static List<Date> findDates(Date dBegin, Date dEnd) {
        List<Date> lDate = new ArrayList<Date>();
        lDate.add(dBegin);
        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间    
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间    
        calEnd.setTime(dEnd);
        // 测试此日期是否在指定日期之后    
        while (dEnd.after(calBegin.getTime())) {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量    
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            lDate.add(calBegin.getTime());
        }
        return lDate;
    }
    
    /**根据日期获取当前月份 */
    public static String getNowMonth(Date date){
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        month = month + 1;
        String monthStr = "";
        if(month <= 9){
        	monthStr = "0" + month;
        }else{
        	monthStr = month + "";
        }
        return monthStr;
    }
    
    /** 根据日期获取上个月最后日期 */
    public static Date getMonthLastDate(Date date){
    	Calendar calendar = Calendar.getInstance(); 
    	calendar.setTime(date);
        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH,calendar.getActualMaximum(Calendar.DAY_OF_MONTH));  
        Date lastDate = calendar.getTime();  
        return lastDate;
    }
    /** 根据日期获取下个月的开始日期 */
    public static Date getPreMonthStart(Date date) {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
    
    /** 获取参数日期的开始日期 */
    public static Date getMonthStartDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (1 - index));
        return calendar.getTime();
    }
    
    /** 获取参数月份的最后一天  */
    public static Date getMonthEndDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, 1);
        int index = calendar.get(Calendar.DAY_OF_MONTH);
        calendar.add(Calendar.DATE, (-index));
        return calendar.getTime();
    }
    
    /**获取传入日期的 零点零分零秒*/
    public static Date getDayOfStart(Date date){ 
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0); 
        cal.set(Calendar.SECOND, 0); 
        cal.set(Calendar.MINUTE, 0); 
        cal.set(Calendar.MILLISECOND, 0); 
        return cal.getTime(); 
   } 
    
    /**
     * 功能描述： 获取与指定日期相差小时的日期
     * 
     * @param days
     *            当前日期差额
     * @return
     */
    public static Date getTargetDate(Date date, int hours) {
        if (date == null) {
            return null;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }
}
