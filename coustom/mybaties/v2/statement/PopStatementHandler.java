package coustom.mybaties.v2.statement;

import coustom.mybaties.v2.config.MapperRegistory;
import coustom.mybaties.v2.resultset.PopResultSetHandler;
import coustom.mybaties.v2.util.SqlHelper;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Pop
 * @date 2019/2/1 16:43
 */
public class PopStatementHandler {

    private  PopResultSetHandler resultSetHandler =null;

    public PopStatementHandler() {
        resultSetHandler = new PopResultSetHandler();
    }

    public <T> T query(MapperRegistory.MapperData mapperData, String params) {

        //进行查询后，将结果交付给resulthandler对象处理返回
        //进行连接
        //然后填充参数
        //交付给ResultSET
        Connection connection = getConnection();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(mapperData.getSql());
            statement.setInt(1,Integer.valueOf(params));
            SqlHelper.setConnection(connection);
            SqlHelper.setStatement(statement);

            return (T)resultSetHandler.handle(statement.executeQuery(),mapperData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private Connection getConnection() {

        Connection connection=null;
        String driverName="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/myssh1";
        String username="root";
        String password="root";
        try {
            Class.forName(driverName);
            connection = DriverManager.getConnection(url,username,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
}
