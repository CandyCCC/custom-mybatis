package coustom.mybaties.v2.config;

import coustom.bean.Employee;
import coustom.mybaties.v2.mapper.MapperProxy;
import coustom.mybaties.v2.session.PopSqlSession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pop
 * @date 2019/2/1 16:07
 */
public class MapperRegistory {
    /**
     * 这个类存在的意义就是用来管理
     * sql语句 -》method的映射
     *
     * namespace.methodName ->(sql,class.type)
     */
    private static final Map<String,MapperData> SQLMEHTODMAPPING = new HashMap();

    public MapperRegistory() {
        SQLMEHTODMAPPING.put("coustom.bean.PopMapper.getPopByPrimaryKey",
                new MapperData("select * from employee where id = ?", Employee.class));
    }

    public <T> T getMapper(Class clazz, PopSqlSession session) {
        //原本，这里应该还要用工厂来生成代理类，我们先直接生成
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},
                new MapperProxy(session));
    }

    public class MapperData<T>{
        private String sql;
        private Class<T> type;

        public MapperData(String sql, Class<T> type) {
            this.sql = sql;
            this.type = type;
        }

        public String getSql() {
            return sql;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }

        public Class<T> getType() {
            return type;
        }

        public void setType(Class<T> type) {
            this.type = type;
        }
    }
    public MapperData get(String namespace){ return SQLMEHTODMAPPING.get(namespace);}
}
