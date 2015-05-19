package de.beat.dem.cards.models;


import com.badlogic.gdx.utils.Array;

/**
 * Created by mkvr on 19.05.15.
 */
public class ActionStack {
    public Array<Card> cards;
    public final Array<Player> players;
    private Player currentPlayer;

    public ActionStack(final Array<Player> players){
        this.players = players;
        this.currentPlayer = players.get(0);
    }
}
