package com.fogok.racegame.model;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.fogok.racegame.control.CarController;

/**
 * Created by FOGOK on 23.12.2016 9:22.
 * Если ты это читаешь, то знай, что этот код хуже
 * кожи разлагающегося бомжа лежащего на гнилой
 * лавочке возле остановки автобуса номер 985
 */
public class Car extends GameObject {

    private CarController carController;
    public Car(Texture texture, float x, float y, float width, float height) {
        super(texture, x, y, width, height);
        carController = new CarController(bounds);
    }

    @Override
    public void draw(SpriteBatch batch) {
        super.draw(batch);
        carController.handle();
    }
}
