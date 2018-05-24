package com.mygdx.mainpackage.Screens;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.mainpackage.Tetris;

public class MainMenuScreen implements Screen{

    private Tetris t;
    private Texture background;
    private Sprite muteSprite = new Sprite (new Texture("sound.png"));
    private Sprite startSprite;
    private Sprite highScoresSprite;
    private Sprite exitSprite;

    private Button exitButton;
    private Button startButton;
    private Button highScoresButton;
    private Button  muteButton = new Button(new SpriteDrawable(muteSprite));

    private Viewport vp;
    private Stage stage;

    public static final float SCREEN_WIDTH = 1600;
    public static final float SCREEN_HEIGHT = 900;

    public MainMenuScreen(final Tetris t){

        this.t = t;
        background = new Texture("wallpaper.jpg");
        //TODO: Mute. A Teresa vai se esquecer...
        muteButton.setX(Gdx.graphics.getWidth() - muteSprite.getWidth());
        muteButton.setY(Gdx.graphics.getHeight() - muteSprite.getRegionHeight());
        muteButton.addListener(new ClickListener(){
          @Override
            public void clicked(InputEvent event, float x, float y){
              if (t.sound == true){
                  muteSprite.set(new Sprite(new Texture("mute.png")));
                  t.sound = false;
              }else {
                  muteSprite.set(new Sprite(new Texture("sound.png")));
                  t.sound = true;
              }
          }
        });

        startSprite = new Sprite (new Texture("startButton.png"));
        startSprite.setSize( (float) (Gdx.graphics.getWidth()*0.09375),  (float) (Gdx.graphics.getHeight()*0.0834));
        startButton = new Button(new SpriteDrawable(startSprite));
        startButton.setX(Gdx.graphics.getWidth()/2 - startButton.getWidth()/2);
        startButton.setY(Gdx.graphics.getHeight()/2 - startButton.getHeight()/2 + startButton.getHeight() * (float)1.5);

        highScoresSprite = new Sprite (new Texture("hsButton.png"));
        highScoresSprite.setSize( (float) (Gdx.graphics.getWidth()*0.09375),  (float) (Gdx.graphics.getHeight()*0.0834));
        highScoresButton = new Button(new SpriteDrawable(highScoresSprite));
        highScoresButton.setX(Gdx.graphics.getWidth()/2 - highScoresButton.getWidth()/2);
        highScoresButton.setY(Gdx.graphics.getHeight()/2 - highScoresButton.getHeight()/2);

        exitSprite = new Sprite(new Texture("exitButton.png"));
        exitSprite.setSize( (float) (Gdx.graphics.getWidth()*0.09375),  (float) (Gdx.graphics.getHeight()*0.0834));
        exitButton = new Button(new SpriteDrawable(exitSprite));
        exitButton.setX(Gdx.graphics.getWidth()/2 - exitButton.getWidth()/2);
        exitButton.setY(Gdx.graphics.getHeight()/2 - exitButton.getHeight()/2 - exitButton.getHeight() * (float) 1.5);

        vp = new FitViewport(SCREEN_WIDTH, SCREEN_HEIGHT);

        stage = new Stage(vp, t.batch);
        stage.addActor(startButton);
        stage.addActor(highScoresButton);
        stage.addActor(exitButton);
        stage.addActor(muteButton);

        Gdx.input.setInputProcessor(stage); //Para podermos dar inputs ao stage :P

    }

    @Override
    public void dispose() {

    }

    @Override
    public void render(float delta) {

        t.batch.begin();
        t.batch.draw(background, 0, 0);
        t.batch.end();
        stage.draw();

        if (exitButton.isPressed()){
            Gdx.app.exit();
        }

        if (highScoresButton.isPressed()){
            this.dispose();
            t.setScreen(new HighScoresScreen(t));
        }
/*
        if (muteButton.isPressed()){
            //TODO: DESLIGAR MUSICA (PARA ISSO E PRECISO PRIMEIRO TER MUSICA)
            //TODO: LIGAR MUSICA (PARA ISSO E PRECISO PRIMEIRO TER MUSICA)
            if (this.sound == true) {
                muteSprite.set(new Sprite(new Texture("mute.png")));
                this.sound = false;
            }else {
                muteSprite.set(new Sprite(new Texture("sound.png")));
                this.sound = true;
            }

            //TODO: OS BOTOES NAO PODEM SER NO RENDER, SE FOREM O MUTE CORRE FPSX POR SEC
/*
            muteButton = new Button(new SpriteDrawable(muteSprite));
            muteButton.setX(Gdx.graphics.getWidth() - muteSprite.getWidth());
            muteButton.setY(Gdx.graphics.getHeight() - muteSprite.getRegionHeight());
            stage.getActors().set(3, muteButton);
        }*/
        
        stage.act();

    }


    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height);
    }
}
