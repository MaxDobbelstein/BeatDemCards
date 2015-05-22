package de.beat.dem.cards;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import de.beat.dem.cards.models.Battle;
import de.beat.dem.cards.screens.BattleScreen;

public class BeatDemCards extends Game {
	public SpriteBatch batch;
	public BitmapFont bitmapFont;

	@Override
	public void create () {
		batch = new SpriteBatch();
		bitmapFont = new BitmapFont();
		this.setScreen(new BattleScreen(this, new Battle()));
	}

	@Override
	public void render () {
		super.render();
	}
}
