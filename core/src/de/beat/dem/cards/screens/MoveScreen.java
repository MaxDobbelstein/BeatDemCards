package de.beat.dem.cards.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.Array;
import de.beat.dem.cards.BeatDemCards;
import de.beat.dem.cards.models.ActionStack;
import de.beat.dem.cards.models.Card;
import de.beat.dem.cards.models.Player;

/**
 * Created by mkvr on 19.05.15.
 */
public class MoveScreen implements Screen {
    private final BeatDemCards beatDemCards;
    private OrthographicCamera camera;
    private ActionStack actionStack;


    public MoveScreen(final BeatDemCards beatDemCards){
        this.beatDemCards = beatDemCards;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);
        Card cardOneKick = new Card("treten", 5, 1, 20);
        Card cardOneHit = new Card("schlagen", 2, 5, 10);
        Card cardTwoKick = new Card("treten", 5, 1, 20);
        Card cardTwoHit = new Card("schlagen", 2, 5, 10);
        Array<Card> cardOne = new Array<Card>();
        cardOne.add(cardOneKick);
        cardOne.add(cardOneHit);
        Array<Card> cardTwo = new Array<Card>();
        cardTwo.add(cardTwoKick);
        cardTwo.add(cardTwoHit);

        Player playerOne = new Player(cardOne, 100, 20, 0);
        Player playerTwo = new Player(cardTwo, 100, 20, 1);

        Array<Player> players = new Array<Player>();
        players.add(playerOne);
        players.add(playerTwo);

        actionStack = new ActionStack(players);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        camera.update();
        beatDemCards.batch.setProjectionMatrix(camera.combined);

        beatDemCards.batch.begin();
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Player" + String.valueOf(actionStack.players.get(0).playerNo), 100, 100);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Hitpoints" + String.valueOf(actionStack.players.get(0).hitPoints), 100, 200);

        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Player" + String.valueOf(actionStack.players.get(1).playerNo), 400, 100);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Hitpoints" + String.valueOf(actionStack.players.get(1).hitPoints), 400, 200);

        beatDemCards.batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
