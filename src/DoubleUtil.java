

import java.math.BigDecimal;

/**
 * 
 * TODO Double类型计算工具类
 * TODO 功能详细描述
 * @author    liu.chunbo
 * @version   
 * @see       
 * @since
 */
public class DoubleUtil {
    //默认除法运算精度,即保留小数点多少位 
    private static final int DEFAULT_DIV_SCALE = 6;
   /** 
    * BigDecimal类型比较
    * @author liu.chunbo
    * 2012-12-14 上午10:08:43
    * @param val1
    * @param val2
    * @return
    */
   public static int compare(BigDecimal val1, BigDecimal val2)
   {
     int result = 0;
     if (val1.compareTo(val2) < 0) {
       result = -1;
     }
     if (val1.compareTo(val2) == 0) {
       result = 0;
     }
     if (val1.compareTo(val2) > 0) {
       result = 1;
     }
     return result;
   }

   /** 
    * Double类型比较
    * @author liu.chunbo
    * 2012-12-14 上午10:08:33
    * @param val1
    * @param val2
    * @return
    */
   public static int compare(Double val1, Double val2)
   {
     BigDecimal data1 = new BigDecimal(val1);
     BigDecimal data2 = new BigDecimal(val2);
     data1 = data1.setScale(8, BigDecimal.ROUND_HALF_UP);
     data2 = data2.setScale(8, BigDecimal.ROUND_HALF_UP);
     return compare(data1,data2);
   }
   
   /** 
    * 小数点后保留指定位数
    * @author liu.chunbo
    * 2012-12-14 上午10:08:10
    * @param val
    * @param scale
    * @return
    */
   public static double round(Double val, int scale)
   {
     BigDecimal b = new BigDecimal(val);
     val = b.setScale(scale, BigDecimal.ROUND_HALF_UP).doubleValue();
     return val;
   }
   
   /** 
    * 提供精确的加法运算。 
    * @param val1 被加数 
    * @param val2 加数 
    * @return 两个参数的和 
    */
   public static double add(double val1, double val2) {
    BigDecimal b1 = new BigDecimal(Double.toString(val1));
    BigDecimal b2 = new BigDecimal(Double.toString(val2));
    return (b1.add(b2)).doubleValue();
   }
   
   /** 
    * 提供精确的减法运算。 
    * @param val1 被减数 
    * @param val2 减数 
    * @return 两个参数的差 
    */
   public static double sub(double val1, double val2) {
    BigDecimal b1 = new BigDecimal(Double.toString(val1));
    BigDecimal b2 = new BigDecimal(Double.toString(val2));
    return (b1.subtract(b2)).doubleValue();
   }
   
   /** 
    * 提供精确的乘法运算。 
    * @param val1 被乘数 
    * @param val2 乘数 
    * @return 两个参数的积 
    */
   public static double mul(double val1, double val2) {
    BigDecimal b1 = new BigDecimal(Double.toString(val1));
    BigDecimal b2 = new BigDecimal(Double.toString(val2));
    return (b1.multiply(b2)).doubleValue();
   }
   
   /** 
    * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 
    * 小数点以后多少位，以后的数字四舍五入。 
    * @param val1 被除数 
    * @param val2 除数 
    * @return 两个参数的商 
    */
   public static double div(double val1, double val2) {
    return div(val1, val2, DEFAULT_DIV_SCALE);
   }
   
   /** 
    * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 
    * 定精度，以后的数字四舍五入。 
    * @param val1 被除数 
    * @param val2 除数 
    * @param scale 表示需要精确到小数点以后几位。 
    * @return 两个参数的商 
    */
   public static double div(double val1, double val2, int scale) {
    if (scale < 0) {
     System.err.println("除法精度必须大于0!");
     return 0;
    }
    BigDecimal b1 = new BigDecimal(Double.toString(val1));
    BigDecimal b2 = new BigDecimal(Double.toString(val2));
    return (b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP)).doubleValue();
   }
  
   public static void main(String[] args) {
    System.out.println("66666777777 ");
   }

}
