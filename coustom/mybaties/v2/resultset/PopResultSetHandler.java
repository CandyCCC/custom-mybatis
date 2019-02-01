package coustom.mybaties.v2.resultset;

import coustom.mybaties.v2.config.MapperRegistory;
import coustom.mybaties.v2.util.SqlHelper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Pop
 * @date 2019/2/1 16:43
 */
public class PopResultSetHandler {
    public <T> T handle(ResultSet resultSet, MapperRegistory.MapperData mapperData) throws IllegalAccessException, InstantiationException, SQLException, NoSuchMethodException, InvocationTargetException {
        //这里要对结果进行拼装

        //创建一个空对象
            Class<T> type = mapperData.getType();
            T t = (T)type.newInstance();//创建了一个空对象
            SqlHelper.setResultSet(resultSet);
            while(resultSet.next()){
                for(Field field : type.getDeclaredFields()){
                    setValue(field,t,resultSet);
                }
            }
            SqlHelper.close();
            return t;
    }

    private void closeResultSet(ResultSet resultSet){
        if(null!=resultSet){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private <T> void setValue(Field field, T t,ResultSet resultSet) throws NoSuchMethodException, SQLException, InvocationTargetException, IllegalAccessException {
        //为了把相应的方法调用出来
        Method method = t.getClass().getMethod("set"+normalizeName(field.getName()),field.getType());
        method.invoke(t,getResult(field,resultSet));
    }

    private Object getResult(Field field, ResultSet resultSet) throws SQLException {
        //取出类型
        Class<?> type = field.getType();
        if(type==Integer.class){
            return resultSet.getInt(field.getName());
        }else if(type==String.class){
            return resultSet.getString(field.getName());
        }
        return resultSet.getString(field.getName());
    }

    private String normalizeName(String name) {
        StringBuilder result = new StringBuilder();
        result.append(name.substring(0,1).toUpperCase());
        result.append(name.substring(1).toLowerCase());
        return result.toString();
    }

}
