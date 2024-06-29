package sample.com.ayushmehara.javafxapp;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class MyMain extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new
                FXMLLoader(getClass().getResource("app_layout.fxml"));
        VBox rootNode = loader.load();

        MenuBar menuBar = createMenu();
        rootNode.getChildren().add(0,menuBar);

        Scene scene = new Scene(rootNode);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Temperature Convertor Tool");
        primaryStage.show();
    }
    private MenuBar createMenu(){
        Menu fileMenu = new Menu("File");
        MenuItem newMenuitem = new MenuItem("New");

        newMenuitem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("New Menu Item Clicked");
            }
        });

        SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();


        MenuItem quitMenuitem = new MenuItem("Quit");
        quitMenuitem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
                System.exit(0);
            }
        });
        fileMenu.getItems().addAll(newMenuitem,separatorMenuItem,quitMenuitem);


        Menu helpMenu = new Menu("Help");
        final MenuItem aboutApp = new MenuItem("About");
        
        aboutApp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                aboutApp();
            }
        });
        helpMenu.getItems().addAll(aboutApp);
        

        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu,helpMenu);

        return menuBar;

    }

    public static void aboutApp() {

        Alert alertdiolog = new Alert(Alert.AlertType.WARNING);
        alertdiolog.setTitle("My First Desktop App");
        alertdiolog.setHeaderText("Learning JavaFX");
        alertdiolog.setContentText("i am just a beginner but soon i will be pro and start deloping awsome app");


        ButtonType yesbtn = new ButtonType("Yes");
        ButtonType nobtn = new ButtonType(" No");

        alertdiolog.getButtonTypes() .setAll(yesbtn,nobtn);

        Optional<ButtonType>clickbtn = alertdiolog.showAndWait();

          if(clickbtn.isPresent() && clickbtn.get() == yesbtn){
              System.out.println("yes button is clicked");

          }else {
              System.out.println("no button is clicked");
          }

    }

}
