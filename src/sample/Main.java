package sample;

import blackjack.Card;
import blackjack.Game;
import blackjack.Globals;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Card.loadCardImages();
        Game game = new Game();
        game.startGame();
        primaryStage.setTitle("Blackjack");
        Button btn = new Button();
        btn.setText("Hit");
        btn.setOnAction(event -> game.hit(game.getDeck(), game.getHuman()));
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        setBackground(root);
        primaryStage.setScene(new Scene(root, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
    }

    private void setBackground(StackPane root){
        BackgroundImage myBI= new BackgroundImage(new Image("table_cropped.jpg",Globals.WINDOW_WIDTH,Globals.WINDOW_HEIGHT,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        root.setBackground(new Background(myBI));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
