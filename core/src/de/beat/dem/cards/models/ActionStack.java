package de.beat.dem.cards.models;


import com.badlogic.gdx.utils.Array;

/**
 * Created by mkvr on 19.05.15.
 */
public class ActionStack {
    public Array<Card> cards;
    public final Array<Player> players;
    private int currentPlayer;

    public ActionStack(final Array<Player> players){
        this.players = players;
        this.currentPlayer = 0;
    }

    public void proceed(){
        int enemy = currentPlayer == 0 ? 1:0;

        for(Card card : cards){
            players.get(enemy).hitPoints -= card.attack;
        }
    }

}
