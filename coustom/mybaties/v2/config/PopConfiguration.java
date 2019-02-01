package coustom.mybaties.v2.config;

import coustom.mybaties.v2.mapper.MapperProxy;
import coustom.mybaties.v2.session.PopSqlSession;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pop
 * @date 2019/2/1 14:00
 */
//就是设置一些参数的值，不应该有过多的逻辑代码
public class PopConfiguration {

    public <T> T getMapper(Class clazz, PopSqlSession session) {
        return registory.getMapper(clazz,session);
    }

    private MapperRegistory registory = new MapperRegistory();

    public MapperRegistory getRegistory() {
        return registory;
    }
    //假设是从xml加载进来的内容 v1版本已经废弃
//    public static class XmlDom{
//        public static final String NAMESPACE = "coustom.bean.PopMapper";
//        public static final Map<String,String> MAPRESIGER = new HashMap<String,String>();
//        static {
//            MAPRESIGER.put("getPopByPrimaryKey","select * from employee where id = ?");
//        }
//    }

}
