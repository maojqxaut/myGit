

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * 
 * 集合操作Util
 * @author    Nicholas
 * @version   
 * @see       
 * @since
 */
public class CollectionUtil {
    
    /**
     * 
     * 一句话功能简述
     * 功能详细描述
     * @param paramLst
     * @param propertyNm
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T, E> List<E> obtainPropertyList(List<T> paramLst, String propertyNm) {
        List<E> retList = new ArrayList<E>();
        try {
            // 遍历集合
            for (T object : paramLst) {
                retList.add((E)getFieldValue(object, propertyNm));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        return retList;
    }
    /**
     * 
     * 一句话功能简述
     * 功能详细描述
     * @param paramLst
     * @param propertyNm
     * @return
     */
    public static <T, E> List<E> obtainPropertyRemoveDuplicateList(List<T> paramLst, String propertyNm) {
        List<E> list = obtainPropertyList(paramLst, propertyNm);
        Set<E> set = new HashSet<E>(list);
        return new ArrayList<E>(set);
    }
    
    /**
     * 根据对象的一个属性，把该对象列表分组（相同的属性作为map的key， 对应的对象数组作为value）
     * 
     * @param list
     * @param propertyName
     * @return
     */
    public static <T, K> Map<K, List<T>> groupList(List<T> list,
            String propertyName) {
        if (list == null) {
            return null;
        }
        Map<K, List<T>> map = new HashMap<K, List<T>>();
        if (list.size() == 0) {
            return map;
        }
        for (T bean : list) {
            K key = getFieldValue(bean, propertyName);
            if (map.containsKey(key)) {
                List<T> mlist = map.get(key);
                mlist.add(bean);
            } else {
                List<T> mlist = new ArrayList<T>();
                mlist.add(bean);
                map.put(key, mlist);
            }
        }
        return map;
    }
    /**
     * 根据对象的一个属性，把该对象列表分组（相同的属性作为map的key， 对应的对象数组作为value）
     * 
     * @param list
     * @param propertyName
     * @return
     */
    public static <T, K> Set<K> groupListToGetKeySet(List<T> list,
            String propertyName) {
        Map<K, List<T>> map = groupList(list, propertyName);
        return map.keySet();
    }

    /**
     * 获得一个对象中 对应属性名的 属性值
     * 
     * @param bean
     * @param propertyName
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static <T> T getFieldValue(Object bean, String fieldName) {
        if (bean == null) {
            return null;
        }
        if (bean instanceof Map) {
            Map map = (Map) bean;
            return (T)map.get(fieldName);
        }
        try {
            Class zlass = bean.getClass();
            Field field = getField(zlass, fieldName);// zlass.getDeclaredField(fieldName);
            if (field == null) {
                return null;
            }
            Method getMethod = fetchGetMethod(zlass, field);
            if (getMethod != null) {
                return (T)getMethod.invoke(bean);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        return null;
    }

    @SuppressWarnings("rawtypes")
    private static Field getField(Class zlass, String fieldName) {
        Field[] fields = zlass.getDeclaredFields();
        if (fields != null) {
            for (int i = 0; i < fields.length; i++) {
                if (fields[i].getName().equals(fieldName)) {
                    return fields[i];
                }
            }
        }
        // 获取父类，递归调用
        Class superClass = zlass.getSuperclass();
        if (superClass != null && superClass != Object.class) {
            return getField(superClass, fieldName);
        }
        return null;
    }

    /**
     * 获得bean 的一个 getMethod
     * 
     * @param zlass
     * @param field
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    private static Method fetchGetMethod(Class zlass, Field field) {
        String fieldName = field.getName();
        String getMethodName = null;
        if (field.getType() == boolean.class) {
            if (fieldName.startsWith("is") && fieldName.length() > 2) {
                char char2 = fieldName.charAt(2);
                if (char2 >= 'A' && char2 <= 'Z') {
                    getMethodName = fieldName;
                } else {
                    getMethodName = "is"
                            + fieldName.substring(0, 1).toUpperCase()
                            + fieldName.substring(1);
                }
            } else {
                getMethodName = "is" + fieldName.substring(0, 1).toUpperCase()
                        + fieldName.substring(1);
            }
        } else {
            getMethodName = "get" + fieldName.substring(0, 1).toUpperCase()
                    + fieldName.substring(1);
        }
        try {
            return zlass.getMethod(getMethodName);
        } catch (NoSuchMethodException e) {
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
    /**
     * @功能描述：list分割
     * @author maojianqiang maojianqiang@metersbonwe.com
     * @2015年11月23日
     * @param
     * @version
     * @param <T>
     */
    public static <T> List<List<T>> splitList(List<T> lists,int limit){  
        int size=lists.size();  
        List<List<T>> list=new ArrayList<List<T>>();  
        if(limit>size){  
            list.add(lists);  
            return list;  
        }  
        int result=0;  
        for(int i=0;i<size;i=i+limit){  
            result=i+limit;  
            if(result>size){  
                result=size;  
            }  
            list.add(lists.subList(i, result));  
        }  
        return list;  
    }  
}
