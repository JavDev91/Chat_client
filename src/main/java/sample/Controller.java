package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.InetAddress;
import java.net.UnknownHostException;

import java.sql.SQLException;


public class Controller {

    String user;
    String ip;
    String komp;
    String kabinet;

    String task_text;
    String task_theme_text;
    String user_name_text;
    String address_host;
    private int resultSet;

    @FXML
    private TextField user_field, kabinet_field;

    @FXML
    private  TextField task_theme, user_name;

    @FXML
    private TextArea task;

    @FXML
    Button btn_task;


    public void new_user() throws SQLException, UnknownHostException {

        user = user_field.getText();
        kabinet = kabinet_field.getText();
        InetAddress addr = InetAddress.getLocalHost();
        ip = addr.getHostAddress();
        komp = addr.getHostName();
        Connect connect = new Connect();
        connect.insert_new_users(user,ip,kabinet,komp);
    }

    public void new_task() throws SQLException, UnknownHostException {

        task_text = task_theme.getText();
        task_theme_text = task.getText();
        task.setPrefColumnCount(6);
        user_name_text = user_name.getText();

        Connect connect = new Connect();
        connect.new_task_SQL(user_name_text,task_theme_text,task_text);

    }

}
