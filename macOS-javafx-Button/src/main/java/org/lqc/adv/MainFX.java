package org.lqc.adv;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFX extends Application
{
    public static int width, height;
    Pane root = new Pane();
    HBox hBox = new HBox();
    Scene scene;
    public static Stage stage;

    void setWindowType(boolean isMax)
    {
        if (isMax)
        {
            root.setPrefSize(width, height);
            hBox.setStyle("-fx-background-radius: 12px");
            root.setStyle("-fx-background-color: grey; -fx-background-radius: 12px; -fx-effect: dropshadow(three-pass-box, #151515, 10, 0, 0, 3)");
            hBox.setPadding(new Insets(10, 10, 10, 10));
        } else {
            System.out.println("Hello world!");
        }
    }

    public static void setMin()
    {
        Platform.runLater(() -> MainFX.stage.setIconified(true));
    }

    public static void setFullScreen()
    {
        Platform.runLater(() -> MainFX.stage.setFullScreen(true));
    }

    public MainFX()
    {
        width = 300;
        height = 300;
        scene = new Scene(hBox, width, height);
        hBox.getChildren().add(root);
        setWindowType(true);
        scene.setFill(Color.TRANSPARENT);
    }

    @Override
    public void start(Stage stage)
    {
        MainFX.stage = stage;
        stage.initStyle(StageStyle.TRANSPARENT);
        new Title().add(root);
        new XButton(root, 8, 8, stage);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
