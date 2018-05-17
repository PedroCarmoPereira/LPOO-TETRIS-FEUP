package com.mygdx.weed;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tetris extends Game {
	SpriteBatch batch;
	Texture img;
	/*
	* public static final float SPEED = pixels/segundo que queremos que a imagem ande, assim fica independente da fps
	* */
	@Override
	public void create () {
		//this.create();
		batch = new SpriteBatch();
		img = new Texture("dick.jpg");
	}

	@Override
	public void render () {
		//this.render();
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 215, 215);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
