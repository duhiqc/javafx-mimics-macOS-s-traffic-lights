package org.lqc.adv;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class XButton
{
    Circle exit = new Circle();
    Circle min = new Circle();
    Circle max = new Circle();
    Circle exitClick = new Circle();
    Circle minClick = new Circle();
    Circle maxClick = new Circle();
    Image image1 = new Image("image.png");
    Image image2 = new Image("exit.png");
    Image image3 = new Image("min.png");
    Image image4 = new Image("max.png");
    ImageView imageView = new ImageView();

    public XButton(Pane root, int x, int y, Stage stage)
    {
        int newX = x + 6;
        int newY = y + 6;
        exit.setFill(Color.web("#ff5048"));
        exit.setRadius(6);
        exit.setCenterX(newX);
        exit.setCenterY(newY);
        min.setFill(Color.web("#feb41e"));
        min.setRadius(6);
        min.setCenterX(newX + 20);
        min.setCenterY(newY);
        max.setFill(Color.web("#18c230"));
        max.setRadius(6);
        max.setCenterX(newX + 40);
        max.setCenterY(newY);
        imageView.setX(newX-16);
        imageView.setY(newY-16);
        root.getChildren().addAll(exit, min, max, imageView);
        exitClick.setRadius(6);
        minClick.setRadius(6);
        maxClick.setRadius(6);
        exitClick.setCenterX(exit.getCenterX());
        exitClick.setCenterY(exit.getCenterY());
        minClick.setCenterX(min.getCenterX());
        minClick.setCenterY(exit.getCenterY());
        maxClick.setCenterX(max.getCenterX());
        maxClick.setCenterY(exit.getCenterY());
        exitClick.setFill(Color.TRANSPARENT);
        minClick.setFill(Color.TRANSPARENT);
        maxClick.setFill(Color.TRANSPARENT);
        root.getChildren().addAll(exitClick, minClick, maxClick);
        addLister(stage);
    }

    private void addLister(Stage stage)
    {
        exitClick.setOnMouseEntered(mouseEvent -> imageView.setImage(image1));
        exitClick.setOnMouseExited(mouseEvent -> imageView.setImage(null));
        exitClick.setOnMousePressed(mouseEvent -> new Thread(() -> {
            try {
                imageView.setImage(image2);
                exit.setFill(Color.web("#ff8179"));
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
        exitClick.setOnMouseReleased(mouseEvent ->
                exitClick.setOnMouseEntered(mouseEvent1 -> {
                    new Thread(() -> {
                        try {
                            exit.setFill(Color.web("#ff5048"));
                            Thread.sleep(5);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }).start();
                    stage.close();
                }));
        minClick.setOnMouseEntered(mouseEvent -> imageView.setImage(image1));
        minClick.setOnMouseExited(mouseEvent -> imageView.setImage(null));
        minClick.setOnMousePressed(mouseEvent -> new Thread(() -> {
            try {
                imageView.setImage(image3);
                min.setFill(Color.web("#feb41e"));
                imageView.setImage(null);
                Thread.sleep(10);
                min.setFill(Color.web("#ffe74d"));
                Thread.sleep(20);
                min.setFill(Color.web("#feb41e"));
                Thread.sleep(10);
                MainFX.setMin();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start());
        maxClick.setOnMouseEntered(mouseEvent -> imageView.setImage(image1));
        maxClick.setOnMouseExited(mouseEvent -> imageView.setImage(null));
        maxClick.setOnMousePressed(mouseEvent -> new Thread(() ->
        {
            try {
                max.setFill(Color.web("#47f560"));
                imageView.setImage(image4);
                Thread.sleep(70);
                max.setFill(Color.web("#18c230"));
                imageView.setImage(null);
                Thread.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            MainFX.setFullScreen();
        }).start());
    }
}
