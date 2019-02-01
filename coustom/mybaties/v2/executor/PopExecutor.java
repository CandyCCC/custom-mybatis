package coustom.mybaties.v2.executor;

import coustom.mybaties.v2.config.MapperRegistory;

/**
 * @author Pop
 * @date 2019/2/1 14:01
 */
public interface PopExecutor {
    <T> T query(MapperRegistory.MapperData mapperData, String params);
}
