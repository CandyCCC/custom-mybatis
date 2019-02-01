package coustom.mybaties.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author Pop
 * @date 2019/1/30 20:27
 */
public class MapperProxy implements InvocationHandler {

    //这是一个比较重要的方法
    //在这里，MapperProxy需要把Sql语句和相对应的方法组合起来
    //但是其实执行的问题还是executor执行
    private PopSqlSession sqlSession;

    public MapperProxy(PopSqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //这里还是执行的，但是由于mapperproxy与普通代理有所区别，所以，我们这里要判断一下
        if(method.getDeclaringClass().getName().equals(PopConfiguration.TestXmlFile.NAMESPACE)){
            //表示是这个类的
            return sqlSession.selectOne(PopConfiguration.TestXmlFile.MAPRESIGER.get(method.getName()),String.valueOf(args[0]));
        }
        return method.invoke(this,args);
    }
}
