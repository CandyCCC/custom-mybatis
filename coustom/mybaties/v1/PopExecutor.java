package coustom.mybaties.v1;

/**
 * @author Pop
 * @date 2019/1/30 20:17
 */
public interface PopExecutor {
    <T> T doQuery(String statement, String params);
    /**
     * 用于执行sql crud操作的执行者
     */
}
