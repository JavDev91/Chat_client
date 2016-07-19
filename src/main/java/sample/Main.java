package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    Stage primaryStage=null;
    AnchorPane init;





    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Task_Chat");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("/first_for_prog.fxml"));
        init =  loader.load();
        Scene scene = new Scene(init);
        primaryStage.setScene(scene);
        primaryStage.show();
        //init();


    }

//    public void init() throws Exception{

//        FXMLLoader loader = new FXMLLoader();
//        loader.setLocation(Main.class.getResource("/sample.fxml"));
//        init =  loader.load();
//        Scene scene = new Scene(init);
//        primaryStage.setScene(scene);
//        primaryStage.show();

//    }

    public void checkUser() {

        Connect connect = new Connect();
        connect.toConnect();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
