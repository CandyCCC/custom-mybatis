package coustom.mybaties.v1;

import java.sql.*;

/**
 * @author Pop
 * @date 2019/1/30 20:26
 */
public class SimplePopExecutor implements PopExecutor {
    @Override
    public <T> T doQuery(String statement1, String params) {
        Connection connection=null;
        PreparedStatement statement =null;
        ResultSet rs=null;
        try{

            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.
                    getConnection("jdbc:mysql://localhost:3306/myssh1","root","root");
            statement = connection.prepareStatement("select * from employee where id = ?");
            statement.setInt(1,Integer.valueOf(params));
            rs = statement.executeQuery();
            while(rs.next()){
                System.out.format("employee (%d,%s)",rs.getInt(1),rs.getString(2));
            }

        }catch (Exception e){
            //ignore
            e.printStackTrace();
        }finally {
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
