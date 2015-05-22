package de.beat.dem.cards.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by mkvr on 19.05.15.
 */
public class PlayerView {
    private final int ROWS = 6;
    private final int COLS = 10;
    private final String ASSETNAME = "bloodSkeletonBase.png";

    private Animation stanceAnimation;
    private Texture texture;
    private TextureRegion[] frames;
    private float stateTime;

    public PlayerView(){
        texture = new Texture(Gdx.files.internal(ASSETNAME)); // #9

        TextureRegion[][] tmp = TextureRegion.split(texture, texture.getWidth()/COLS, texture.getHeight()/ROWS);              // #10
        frames = new TextureRegion[COLS];

        for (int j = 0; j < COLS; j++)
                frames[j] = tmp[0][j];


        stanceAnimation = new Animation(0.1f, frames);      // #11
        stateTime = 0f;
    }

    public TextureRegion getCurrentFrame(float stateTime){
        this.stateTime += stateTime;
        return stanceAnimation.getKeyFrame(this.stateTime, true);
    }

}
