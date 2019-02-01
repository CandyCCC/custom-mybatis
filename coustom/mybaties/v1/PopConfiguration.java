package coustom.mybaties.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pop
 * @date 2019/1/30 20:18
 */
public class PopConfiguration {

    public <T> T getMapper(Class<T> clazz, PopSqlSession session) {
        return (T)Proxy.newProxyInstance(this.getClass().getClassLoader(),
                new Class[]{clazz},new MapperProxy(session));
    }
    /**
     * 配置文件的管理者
     */
    //假设我们已经完成了xml的解析工作
    static  class TestXmlFile{
        public static final  String NAMESPACE = "coustom.bean.PopMapper";
        public static final Map<String,String> MAPRESIGER = new HashMap<String,String>();
        static {
            MAPRESIGER.put("getPopByPrimaryKey","select * from employee where id = ?");//比如说已经注册好了
        }
    }
}
