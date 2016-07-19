package sample;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import java.sql.SQLException;

public class Controller {

    String user;
    String ip;
    String komp;
    String kabinet;

    @FXML
    private TextField user_field;
    @FXML
    private TextField ip_field;
    @FXML
    private TextField kabinet_field;
    @FXML
    private TextField computer_field;


    public void new_user()  throws SQLException {

        user = user_field.getText();
        ip = ip_field.getText();
        kabinet = kabinet_field.getText();
        komp = computer_field.getText();
        Connect connect = new Connect();
        connect.insert_new_users(user,ip,kabinet,komp);
    }

}
