package de.beat.dem.cards.models;

import com.badlogic.gdx.utils.Array;

/**
 * Created by mkvr on 22.05.15.
 */
public class Battle {

    public Player playerOne;
    public Player playerTwo;


    public Battle(){
        playerOne = createPlayer(PlayerNumber.One);
        playerTwo = createPlayer(PlayerNumber.Two);
    }

    private Player createPlayer(PlayerNumber playerNumber){
        Array<Card> cards = initialiseCards();
        Player playerOne = new Player(cards, 100, 20, playerNumber);

        return playerOne;
    }

    private Array<Card> initialiseCards(){
        Card cardOneKick = new Card("treten","kick", 5, 1, 20);
        Card cardOneHit = new Card("schlagen", "punch", 2, 5, 10);
        Array<Card> cards = new Array<Card>();
        cards.add(cardOneKick);
        cards.add(cardOneHit);

        return cards;
    }


}
