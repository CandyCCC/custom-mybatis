package coustom.bean;

/**
 * @author Pop
 * @date 2019/1/30 20:37
 */
public interface PopMapper {
    <T> T getPopByPrimaryKey(Integer id);
}
