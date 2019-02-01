package coustom.mybaties.v2.mapper;

import coustom.mybaties.v2.config.MapperRegistory;
import coustom.mybaties.v2.config.PopConfiguration;
import coustom.mybaties.v2.session.PopSqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Pop
 * @date 2019/2/1 14:59
 */
public class MapperProxy implements InvocationHandler {

    private PopSqlSession session=null;

    public MapperProxy(PopSqlSession session) {
        this.session = session;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //如果是映射的响应的方法，我们就使用其他方法调用
        MapperRegistory.MapperData mapperData =session.
                getConfiguration().getRegistory().get(method.getDeclaringClass().getName()+"."+method.getName());
        if(null!=mapperData){
            //找到了，开始执行操作
            return session.selectOne(mapperData,String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
