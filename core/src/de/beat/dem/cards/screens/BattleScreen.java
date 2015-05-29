package de.beat.dem.cards.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;
import de.beat.dem.cards.BeatDemCards;
import de.beat.dem.cards.models.Battle;
import de.beat.dem.cards.models.Card;
import de.beat.dem.cards.models.Player;
import de.beat.dem.cards.models.PlayerNumber;
import de.beat.dem.cards.views.CardView;
import de.beat.dem.cards.views.PlayerView;

/**
 * Created by mkvr on 19.05.15.
 */
public class BattleScreen implements Screen {
    public static final String PLAYER = "Player";
    public static final String HITPOINTS = "Hitpoints";
    public static final String MOVEPOINTS = "Movepoints";
    private static int RESOLUTION_WIDTH  = 800;
    private static int RESOLUTION_HEIGHT = 600;

    private static int X_POSITION_PLAYER_ONE = 100;
    private static int X_POSITION_PLAYER_TWO = 600;
    private static int Y_POSITION_PLAYERS    = 200;
    private static int Y_POSITION = 100;
    private static int ROW_HEIGHT = 15;

    private final int CARD_WIDTH = 80;
    private final int CARD_HEIGHT = 95;
    private final int CARD_Y_POSITION = 400;

    private final BeatDemCards beatDemCards;
    private OrthographicCamera camera;

    private PlayerView playerOne;
    private PlayerView playerTwo;
    private Array<CardView> playerOneCards;
    private Array<CardView> playerTwoCards;

    private Battle battle;

    public BattleScreen(final BeatDemCards beatDemCards, Battle battle){
        this.beatDemCards = beatDemCards;
        this.battle = battle;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, RESOLUTION_WIDTH, RESOLUTION_HEIGHT);

        initialisePlayers();
        
        playerOneCards = initialiseCardViews(battle.playerOne.cards, X_POSITION_PLAYER_ONE - 50);
        playerTwoCards = initialiseCardViews(battle.playerTwo.cards, X_POSITION_PLAYER_TWO - 50);
    }
    
    private void initialisePlayers(){
        playerOne = new PlayerView();
        playerOne.xPosition = X_POSITION_PLAYER_ONE;
        playerOne.yPosition = Y_POSITION_PLAYERS;
        playerTwo = new PlayerView();
        playerTwo.xPosition = X_POSITION_PLAYER_TWO;
        playerTwo.yPosition = Y_POSITION_PLAYERS;
        playerTwo.flipX     = true;
    }

    private Array<CardView> initialiseCardViews(Array<Card> cards, int initialPositionX){
        int counter = 0;
        int offSet = CARD_WIDTH + 1;
        Array<CardView> cardViews = new Array<CardView>();

        for(Card card : cards){
            CardView currCard = new CardView(card.cardName);
            currCard.xPosition = initialPositionX + (counter * offSet);
            currCard.yPosition = CARD_Y_POSITION;
            cardViews.add(currCard);
            counter++;
        }

        return cardViews;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        resetScreen();

        beatDemCards.batch.begin();
        drawPlayerValues(PlayerNumber.One);
        drawPlayerSprite(playerOne, delta);
        drawPlayerCards(playerOneCards);

        drawPlayerValues(PlayerNumber.Two);
        drawPlayerSprite(playerTwo, delta);
        drawPlayerCards(playerTwoCards);

        beatDemCards.batch.end();
    }

    private void resetScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        beatDemCards.batch.setProjectionMatrix(camera.combined);
    }

    private void drawPlayerValues(PlayerNumber playerNumber) {
        int startPositionX = playerNumber == PlayerNumber.One ? X_POSITION_PLAYER_ONE : X_POSITION_PLAYER_TWO;
        int positionY = Y_POSITION;
        int rowHeight = ROW_HEIGHT;
        Player player = playerNumber == PlayerNumber.One ? battle.playerOne : battle.playerTwo;

        beatDemCards.bitmapFont.draw(beatDemCards.batch, PLAYER + String.valueOf(player.playerNo.toString()), startPositionX, positionY);
        positionY -= rowHeight;
        beatDemCards.bitmapFont.draw(beatDemCards.batch, HITPOINTS + String.valueOf(player.hitPoints), startPositionX, positionY);
        positionY -= rowHeight;
        beatDemCards.bitmapFont.draw(beatDemCards.batch, MOVEPOINTS + String.valueOf(player.hitPoints), startPositionX, positionY);
    }

    private void drawPlayerSprite(PlayerView player, float delta){
        TextureRegion currentFrame = player.getCurrentFrame(delta);
        Sprite playerSprite = new Sprite(currentFrame);
        
        playerSprite.setSize(player.width, player.height);
        playerSprite.setPosition(player.xPosition, player.yPosition);
        playerSprite.flip(player.flipX, player.flipY);

        playerSprite.draw(beatDemCards.batch);
        //beatDemCards.batch.draw(currentFrame, player.xPosition, player.yPosition, player.width, player.height);
    }

    private void drawPlayerCards(Array<CardView> cardViews){
        for(CardView currentCard : cardViews){
            beatDemCards.batch.draw(currentCard.CARDIMAGE, currentCard.xPosition, currentCard.yPosition, 
                    CARD_WIDTH, CARD_HEIGHT);
        }
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
