package coustom.mybaties.v2.main;

import coustom.bean.Employee;
import coustom.bean.PopMapper;
import coustom.mybaties.v2.config.PopConfiguration;
import coustom.mybaties.v2.executor.SimplePopExecutor;
import coustom.mybaties.v2.session.PopSqlSession;

/**
 * @author Pop
 * @date 2019/2/1 15:13
 */
public class Entry {

    public static void main(String[] args) {
        PopSqlSession session =new PopSqlSession(new PopConfiguration(), new SimplePopExecutor());
        PopMapper mapper = session.getMapper(PopMapper.class);
        Employee e=mapper.getPopByPrimaryKey(1);
        System.out.println(e);
    }

}
