package de.beat.dem.cards.models;

import com.badlogic.gdx.utils.Array;

/**
 * Created by mkvr on 19.05.15.
 */
public class Player {
    public Array<Card> deck;
    public int hitPoints;
    public int movePoints;
    public final int playerNo;

    public Player(Array<Card> deck, int hitPoints, int movePoints, final int playerNo){
        this.deck = deck;
        this.hitPoints = hitPoints;
        this.movePoints = movePoints;
        this.playerNo = playerNo;
    }
}
