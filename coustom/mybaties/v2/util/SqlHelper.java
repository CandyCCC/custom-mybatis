package coustom.mybaties.v2.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Pop
 * @date 2019/2/1 17:43
 */
public class SqlHelper {
    private static Connection connection=null;
    private static PreparedStatement statement = null;
    private static ResultSet resultSet=null;

    public static void setConnection(Connection con) {
        connection = con;
    }

    public static void setStatement(PreparedStatement stat) {
        statement = stat;
    }

    public static void setResultSet(ResultSet result) {
        resultSet = result;
    }

    public  static void close(){
        try {
            if(null!=resultSet){
                resultSet.close();
            }
            if(null!=statement){
                statement.close();
            }
            if(null!=connection){
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
