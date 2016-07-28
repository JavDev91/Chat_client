package sample;

/**
 * Created by prog on 18.07.2016.
 */

import com.mysql.jdbc.PreparedStatement;

import java.net.InetAddress;
import java.net.UnknownHostException;
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
    private static ResultSet rs;
    private String query;
    private String qr;

    private String user;
    private String ip;
    private String kabinet;
    private String komp;
    private String check;
    private String ip_host;

    private String author, theme, task_text;

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

    public void insert_new_users(String user, String ip, String kabinet, String komp) throws SQLException, UnknownHostException {

        this.user = user;
        this.ip = ip;
        this.kabinet = kabinet;
        this.komp = komp;


        query = "INSERT INTO `taskchat`.`users` (`Login`, `IP`, `KABINET`, `KABINET.COMP`) VALUES (" + "'"+ user.toString() + "'," + "'" + ip.toString() + "'," + "'" + kabinet.toString() + "'," + "'" + komp.toString() + "')";

        toConnect();
        stmp = connection.createStatement();
        resultSet = stmp.executeUpdate(query);
        toDisconnect();

    }

    public boolean checkUsers(String check) throws SQLException, UnknownHostException{

        this.check = check;
        boolean otvet = false;
        String otvetSql = "";
        String query = "SELECT IP FROM taskchat.users WHERE " + "'" +check + "'";
        toConnect();
        stmp = connection.createStatement();
        rs = stmp.executeQuery(query);
        while (rs.next()) {
            otvetSql = rs.getString(1);
        }
        if (otvetSql.equals(check) ) {
            otvet = true;
        } else {
            otvet = false;
        }
        return otvet;

    }

    public void new_task_SQL(String author, String theme, String task_text) throws SQLException, UnknownHostException {

        this.author = author;
        this.theme = theme;
        this.task_text = task_text;
        InetAddress address = InetAddress.getLocalHost();

        String quer = "INSERT INTO taskchat.tasks( Task_autor, Task_theme, Task_name, IP_author) VALUES " +
                "(" + "'" + author + "'," + "'" + theme + "'," + "'" + task_text + "',"
                + "'" + address.getHostAddress() + "')";

        toConnect();
        stmp = connection.createStatement();
        resultSet = stmp.executeUpdate(quer);
        toDisconnect();




    }


}