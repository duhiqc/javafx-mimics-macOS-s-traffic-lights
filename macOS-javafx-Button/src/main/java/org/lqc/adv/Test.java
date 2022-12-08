package org.lqc.adv;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test extends Application
{
    VBox vBox = new VBox();
    @Override
    public void start(Stage stage)
    {
        stage.setScene(new Scene(vBox, 300, 300));
        Button button = new Button();
        vBox.getChildren().add(button);
        vBox.setAlignment(Pos.CENTER);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
