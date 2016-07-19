package sample;

/**
 * Created by prog on 18.07.2016.
 */

import com.mysql.jdbc.PreparedStatement;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connect {

    private String login = "root";
    private String password = "8323102";
    private String URL = "jdbc:mysql://10.41.0.111:3306";
    private static Statement stmp;
    private static int resultSet;

    private String user;
    private String ip;
    private String kabinet;
    private String komp;

    java.sql.Connection connection = null;


    public void toConnect() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection(URL, login, password);
            if (connection!=null) {
                System.out.println("connect success");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        }

    public void toDisconnect() throws SQLException {

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insert_new_users(String user, String ip, String kabinet, String komp) throws SQLException {

        this.user = user;
        this.ip = ip;
        this.kabinet = kabinet;
        this.komp = komp;


        String query = "INSERT INTO `taskchat`.`users` (`Login`, `IP`, `KABINET`, `KABINET.COMP`) VALUES (" + "'"+ user.toString() + "'," + "'" + ip.toString() + "'," + "'" + kabinet.toString() + "'," + "'" + komp.toString() + "')";

        connection = DriverManager.getConnection(URL, login, password);
        stmp = connection.createStatement();
        resultSet = stmp.executeUpdate(query);





    }

//    public static void main(String [] args) throws SQLException {
//
//
//
//
//    }


}