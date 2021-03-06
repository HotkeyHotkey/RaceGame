package com.fogok.racegame.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.fogok.racegame.model.Car;
import com.fogok.racegame.utils.UI;

/**
 * Created by FOGOK on 23.12.2016 8:21.
 * Если ты это читаешь, то знай, что этот код хуже
 * кожи разлагающегося бомжа лежащего на гнилой
 * лавочке возле остановки автобуса номер 985
 */
public class GameScreen implements Screen {

    private TextureAtlas textureAtlas;
    private SpriteBatch batch;
    private Car car;
    private OrthographicCamera camera;
    private UI ui;


    public static float deltaCff;

    @Override
    public void show() {
        batch = new SpriteBatch();
        car = new Car(textureAtlas.findRegion("0"), 0f, 0f, 1f, 1f * 1.97f);
        ui = new UI();

        resize(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
    }

    public void setTextureAtlas(TextureAtlas textureAtlas) {
        this.textureAtlas = textureAtlas;
    }


    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0.3f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        deltaCff = delta;

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        car.draw(batch);
        batch.end();
        ui.draw();
    }

    @Override
    public void resize(int width, int height) {
        float aspectRatio = (float) height / width;
        camera = new OrthographicCamera(20f, 20f * aspectRatio);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        ui.dispose();
    }
}
