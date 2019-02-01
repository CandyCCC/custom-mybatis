package coustom.mybaties.v2.session;

import coustom.mybaties.v2.config.MapperRegistory;
import coustom.mybaties.v2.config.PopConfiguration;
import coustom.mybaties.v2.executor.PopExecutor;

/**
 * @author Pop
 * @date 2019/2/1 13:47
 */
public class PopSqlSession {
    private PopConfiguration configuration;
    private PopExecutor executor;

    public PopConfiguration getConfiguration() {
        return configuration;
    }

    public PopSqlSession(PopConfiguration configuration, PopExecutor executor) {
        this.configuration = configuration;
        this.executor = executor;
    }

    //定义行为
    public <T> T getMapper(Class<?> clazz){
        return configuration.getMapper(clazz,this);
    }

    public <T> T selectOne(MapperRegistory.MapperData mapperData, String params){
        return executor.query(mapperData,params);
    }
}
