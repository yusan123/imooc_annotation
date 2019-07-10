package com.yu.demo;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2019/7/10.
 */
public class Test {
    public static void main(String[] args) throws NoSuchMethodException {

        Filter f1 = new Filter();
        f1.setId(10);

        Filter f2 = new Filter();
        f2.setUserName("luck,yusen");

        Filter f3 = new Filter();
        f3.setCity("bj,sh,xa");

        String sql1 = query(f1);
        String sql2 = query(f2);
        String sql3 = query(f3);

        System.out.println(sql1);
        System.out.println(sql2);
        System.out.println(sql3);


        Student student = new Student();
        student.setName("yusan");
        student.setAge(10);
        student.setCity("cq,tj,sz");
        System.out.println(query(student));
    }

    private static String query(Object obj) throws NoSuchMethodException {
        StringBuilder sb = new StringBuilder();
        //1获取字节码文件
        Class<?> c = obj.getClass();
        //2获取表名
        boolean isTable = c.isAnnotationPresent(Table.class);
        if (!isTable) {
            return null;
        }
        Table table = c.getAnnotation(Table.class);
        String tableName = table.value();
        sb.append("select * from ").append(tableName).append(" where 1=1");

        //3遍历获取所有字段
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            //4处理每个字段的sql

            if(field.isAnnotationPresent(Column.class)){
                Column column = field.getAnnotation(Column.class);
                //4.1拿到每个字段名
                String columnName = column.value();
                //4.2拿到每个字段值
                String getFiledMethod = "get"+field.getName().substring(0,1).toUpperCase()+
                        field.getName().substring(1);

                Method method = c.getMethod(getFiledMethod);
                Object invoke = null;
                try {
                    invoke = method.invoke(obj);

                } catch (Exception e) {
                    e.printStackTrace();
                }
                //4.3拼装sql
                if(invoke!=null){ //只拼装有值得字段
                    sb.append(" and ").append(columnName);
//                    如果是字符串类型的字段
                    if (invoke instanceof String){
                        String invoke1 = (String) invoke;
//                        如果该字符串中包含了，说明使用in去查询
                        if(invoke1.contains(",")){
                            sb.append(" in (");
                            String[] values = invoke1.split(",");
                            for (String value : values) {
                                sb.append("'").append(value).append("',");
                            }
                            sb.deleteCharAt(sb.length()-1);
                            sb.append(")");
                        }else {
                            sb.append("='").append(invoke1).append("'");
                        }
                    }else{
                        sb.append("=").append(invoke);
                    }

                }

            }

        }
        return sb.toString();
    }
}
