package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.InetAddress;

public class Main extends Application {

    Stage primaryStage=null;
    AnchorPane init;





    @Override
    public void start(Stage primaryStage) throws Exception {

        InetAddress addr = InetAddress.getLocalHost();
        Connect connect = new Connect();





        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Task_Chat");
        FXMLLoader loader = new FXMLLoader();
        if (connect.checkUsers(addr.toString())) {
            loader.setLocation(Main.class.getResource("/first_for_prog.fxml"));
        } else {
            loader.setLocation(Main.class.getResource("/sample.fxml"));
        }

        init = loader.load();
        Scene scene = new Scene(init);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
