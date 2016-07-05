

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Function: 由WMS出入库单源头单据类别或出入库方式确定账务中心的业务类型
 * @Author: yangqingbo@metersbonwe.com
 * @Time: 2015年9月14日上午10:57:01
 */
public class BusinessTypeConvertUtil {
    //WMS出库单源头单据类别, 第1个参数为WMS源头单据类别字典CODE, 第2个参数为账务中心业务类型字典CODE
    public static Map<String, String> docTypeOutMap = new HashMap<String, String>();

    //WMS出库单出库方式
    public static Map<String, String> delivModeMap = new HashMap<String, String>();

    //WMS入库单源头单据类别
    public static Map<String, String> docTypeInMap = new HashMap<String, String>();

    //WMS入库单入库方式
    public static Map<String, String> rcptModeMap = new HashMap<String, String>();

    //老模式同新模式处理逻辑的出入库方式
    public static Map<String, String> oldInLineWithNewMap = new HashMap<String, String>();
    
}
