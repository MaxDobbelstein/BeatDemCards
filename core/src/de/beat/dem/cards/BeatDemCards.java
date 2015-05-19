package de.beat.dem.cards;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import de.beat.dem.cards.screens.MoveScreen;

public class BeatDemCards extends Game {
	public SpriteBatch batch;
	public BitmapFont bitmapFont;

	Texture img;
	private Rectangle bucket;


	@Override
	public void create () {
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		this.setScreen(new MoveScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
