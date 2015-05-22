package de.beat.dem.cards.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import de.beat.dem.cards.BeatDemCards;
import de.beat.dem.cards.models.ActionStack;
import de.beat.dem.cards.models.Card;
import de.beat.dem.cards.models.Player;
import de.beat.dem.cards.views.CardView;
import de.beat.dem.cards.views.PlayerView;

/**
 * Created by mkvr on 19.05.15.
 */
public class MoveScreen implements Screen {
    private final BeatDemCards beatDemCards;
    private OrthographicCamera camera;
    private ActionStack actionStack;
    private PlayerView playerView;
    private PlayerView playerView2;
    private Array<CardView> currentCards;
    private Array<CardView> currentCards2;

    public MoveScreen(final BeatDemCards beatDemCards){
        this.beatDemCards = beatDemCards;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 640, 480);
        Card cardOneKick = new Card("treten","kick", 5, 1, 20);
        Card cardOneHit = new Card("schlagen", "punch", 2, 5, 10);
        Card cardTwoKick = new Card("treten", "kick", 5, 1, 20);
        Card cardTwoHit = new Card("schlagen","punch", 2, 5, 10);
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
        playerView = new PlayerView();
        playerView2 = new PlayerView();
        
        currentCards = new Array<CardView>();
        currentCards2 = new Array<CardView>();
        
        for(Card currCard : cardOne){
            currentCards.add(new CardView(currCard.cardName));
        }
        for(Card currCard : cardTwo){
            currentCards2.add(new CardView(currCard.cardName));
        }
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        beatDemCards.batch.setProjectionMatrix(camera.combined);

        beatDemCards.batch.begin();
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Player" + String.valueOf(actionStack.players.get(0).playerNo), 100, 100);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Hitpoints" + String.valueOf(actionStack.players.get(0).hitPoints), 100, 85);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Movepoints" + String.valueOf(actionStack.players.get(0).hitPoints), 100, 70);
        beatDemCards.batch.draw(playerView.getCurrentFrame(delta), 100, 200);

        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Player" + String.valueOf(actionStack.players.get(1).playerNo), 400, 100);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Hitpoints" + String.valueOf(actionStack.players.get(1).hitPoints), 400, 85);
        beatDemCards.bitmapFont.draw(beatDemCards.batch, "Movepoints" + String.valueOf(actionStack.players.get(0).hitPoints), 400, 70);
        
        int offset = 0;
        for(CardView currCard : currentCards){
            beatDemCards.batch.draw(currCard.cardImage, 0 + offset, 300,128, 96);
            offset +=133;
        }
        offset =0;
        for(CardView currCard : currentCards2){
            beatDemCards.batch.draw(currCard.cardImage, 300  + offset, 300, 128, 96);
            offset +=133;
        }
        
        
        /*draw (Texture texture, float x, float y, float width, float height, int srcX, int srcY, int srcWidth,
        int srcHeight, boolean flipX, boolean flipY)*/
        TextureRegion currentFrame = playerView2.getCurrentFrame(delta);
        beatDemCards.batch.draw(currentFrame, 400, 200,
                ((float) -currentFrame.getRegionWidth()), ((float) currentFrame.getRegionHeight()));

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
