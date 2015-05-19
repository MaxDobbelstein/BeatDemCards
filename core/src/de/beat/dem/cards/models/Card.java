package de.beat.dem.cards.models;

/**
 * Created by mkvr on 19.05.15.
 */
public class Card {
    public final String action;
    public final int attack;
    public final int defend;
    public final int movePoints;

    public Card(final String action, final int attack, final int defend, final int movePoints){
        this.action = action;
        this.attack = attack;
        this.defend = defend;
        this.movePoints = movePoints;
    }
}
