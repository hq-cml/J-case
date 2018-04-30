package com.advanced.Jcase.Annotation2;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Util {
    public static String query(Object o) {
        StringBuilder sb = new StringBuilder();

        //获取到class
        Class clazz = o.getClass();

        //获取table表名
        boolean exists = clazz.isAnnotationPresent(Table.class);
        if (!exists) {
            return null;
        }
        Table tableAnnotation = (Table)clazz.getAnnotation(Table.class);
        String tableName = tableAnnotation.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //遍历字段名
        Field[] fArray = clazz.getDeclaredFields();
        for(Field field:fArray) {
            //获取字段名
            boolean fExists = field.isAnnotationPresent(Column.class);
            if (!fExists) {
                continue;
            }
            Column columnAnnotation = field.getAnnotation(Column.class);
            String columnName = columnAnnotation.value();

            //获取字段值
            String filedName = field.getName();
            String getMethodName = "get" + filedName.substring(0, 1).toUpperCase() + filedName.substring(1);

            Object fieldValue = null;
            try{
                Method getMethod = clazz.getMethod(getMethodName);
                fieldValue = getMethod.invoke(o); //通过反射调用get方法

                if (fieldValue == null ||
                        (fieldValue instanceof  Integer && (Integer)fieldValue==0)){
                    continue;
                }

                if(fieldValue instanceof String ) {
                    sb.append(" and ").append(columnName).append("='").append(fieldValue).append("'");
                } else {
                    sb.append(" and ").append(columnName).append("=").append(fieldValue);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
