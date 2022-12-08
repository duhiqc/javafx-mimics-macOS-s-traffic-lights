package org.lqc.adv;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Title
{
    Rectangle rect1 = new Rectangle();
    Rectangle rect2 = new Rectangle();

    public void add(Pane root)
    {
        rect1.setWidth(MainFX.width - 20);
        rect2.setWidth(MainFX.width - 20);
        rect1.setHeight(26);
        rect2.setHeight(13);
        rect1.setFill(Color.WHITE);
        rect2.setFill(Color.WHITE);
        rect1.setY(0);
        rect2.setY(14);
        rect1.setArcWidth(30);
        rect1.setArcHeight(30);
        root.getChildren().addAll(rect1, rect2);
    }
}
