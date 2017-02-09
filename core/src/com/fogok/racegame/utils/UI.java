package com.fogok.racegame.utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by FOGOK on 09.02.2017 10:32.
 * Если ты это читаешь, то знай, что этот код хуже
 * кожи разлагающегося бомжа лежащего на гнилой
 * лавочке возле остановки автобуса номер 985
 */
public class UI {

    private Stage stage;
    private Skin skin;
    private Label label;

    public UI() {
        stage = new Stage(new FitViewport(800, 600));
        skin = new Skin(Gdx.files.internal("skin.json"));
        addLabelToStage();
    }

    private void addLabelToStage(){
        label = new Label("HELLO!\nMy name is\nOleg", skin.get("default", Label.LabelStyle.class));
        label.setAlignment(Align.center);
        label.setPosition(400, 300, Align.center);
        label.setFontScale(.3f);
        stage.addActor(label);
    }

    public void draw(){
        stage.getViewport().update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        stage.act();
        stage.draw();
    }

    public void dispose() {
        stage.dispose();
    }
}
