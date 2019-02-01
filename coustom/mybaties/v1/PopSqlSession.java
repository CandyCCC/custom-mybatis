package coustom.mybaties.v1;

/**
 * @author Pop
 * @date 2019/1/30 20:16
 */
public class PopSqlSession {
    /**
     * 发起一个对sql的一次会话
     */
    private PopExecutor executor;
    private PopConfiguration configuration;

    public PopSqlSession(PopExecutor executor, PopConfiguration configuration) {
        this.executor = executor;
        this.configuration = configuration;
    }

    /**
     * 开始定义这个会话具有的行为
     * 如果是之前的使用mybatis的方法的话
     * 通过getMapper得到相应的对象，这个是用session做到的，那么我们也可以
     * 定义一个这样的方法，然后做一个拓展
     */
    public <T> T getMapper(Class<T> clazz){
        return configuration.getMapper(clazz,this);
    }

    /**
     * 然后就是，我们这个session一开始其实也是具有查询的方法的
     * 我们也是定义到这里来的，但是请注意，处理方法的具体实现不应该
     * 放在这个地方，因为他的职责并不是执行sql语句的
     */
    public <T> T selectOne(String statement,String params){
        return executor.doQuery(statement,params);
    }

}
