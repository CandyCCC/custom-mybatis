package coustom.mybaties.v2.executor;

import coustom.mybaties.v2.config.MapperRegistory;
import coustom.mybaties.v2.statement.PopStatementHandler;

import java.sql.*;

/**
 * @author Pop
 * @date 2019/2/1 15:13
 */
public class SimplePopExecutor implements PopExecutor {

    @Override
    public <T> T query(MapperRegistory.MapperData mapperData, String params) {
        PopStatementHandler handler = new PopStatementHandler();
       return (T)handler.query(mapperData,params);
    }
}
