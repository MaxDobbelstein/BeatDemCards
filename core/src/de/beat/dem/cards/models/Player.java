package de.beat.dem.cards.models;

import com.badlogic.gdx.utils.Array;

/**
 * Created by mkvr on 19.05.15.
 */
public class Player {
    public Array<Card> cards;
    public int hitPoints;
    public int movePoints;
    public final PlayerNumber playerNo;

    public Player(Array<Card> cards, int hitPoints, int movePoints, final PlayerNumber playerNo){
        this.cards = cards;
        this.hitPoints = hitPoints;
        this.movePoints = movePoints;
        this.playerNo = playerNo;
    }
}
