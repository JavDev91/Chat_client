package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {

    AnchorPane init;
    Stage primaryStage;

    private final String STATEMENT = "";


    @Override
    public void start(Stage primaryStage) throws Exception{

        this.primaryStage = primaryStage;
        primaryStage.setTitle("Task_Chat");
        init();


    }

    public void init() throws Exception{

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/sample.fxml"));
        init = loader.load();
        Scene scene = new Scene(init);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public void checkUser() {

        Connect connect = new Connect();
        connect.toConnect();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
