package coustom.mybaties.v1;

import coustom.bean.PopMapper;

/**
 * @author Pop
 * @date 2019/1/30 20:49
 */
public class Entry {
    public static void main(String[] args) {
        PopSqlSession session =new  PopSqlSession( new SimplePopExecutor(),new PopConfiguration());
        PopMapper mapper = session.getMapper(PopMapper.class);
        mapper.getPopByPrimaryKey(1);
    }
}
