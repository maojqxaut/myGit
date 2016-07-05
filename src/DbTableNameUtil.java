/*
 * 文件名：DbTableNameUtil.java 版权：Copyright 2014 MetersBonwe. All Rights Reserved. 描述：TODO 修改人：Weijf 修改时间：下午3:56:13 修改内容：
 */



import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 分表工具类
 * 
 * @author Weijf
 * @version
 * @see
 * @since
 */

public class DbTableNameUtil {
    /**
     * 将数据使用MD5转码
     * 
     * @throws NoSuchAlgorithmException
     * @@param message
     * @@return
     */
    private static byte[] encrypt(String message)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.reset();
        return md.digest(message.getBytes());

    }

    public static String getInventoryTableName(String begin, String warehId)
            throws Exception {
        BigInteger bi = new BigInteger(1, encrypt(warehId));
        return begin + "_" + bi.mod(new BigInteger("33"));
    }

    public static String getCostTableName(String begin, String unitId)
            throws Exception {
        return begin + "_" + unitId;
    }

    public static String getStorageTableName(String begin, Date date)
            throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return begin + "_" + sdf.format(date);
    }

    public static String byteToHexString(byte[] md5Bytes) {

        StringBuffer hexValue = new StringBuffer();

        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xFF;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }

        return hexValue.toString();
    }
}
