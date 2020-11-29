package sample;

import javafx.scene.image.Image;

public abstract class Obstacle extends Elements {
    public Obstacle(Image ip)
    {
        super(ip);
        this.setFitHeight(160);
        this.setFitWidth(160);
    }
}
