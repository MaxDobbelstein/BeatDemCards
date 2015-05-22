package de.beat.dem.cards.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
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
    private static int RESOLUTIONWIDTH = 800;
    private static int RESOLUTIONHEIGHT = 600;

    private static int XPOSITIONPLAYERONE = 100;
    private static int XPOSITIONPLAYERTWO = 400;
    private static int YPOSITION = 100;
    private static int ROWHEIGHT = 15;

    private final int CARDHEIGHT = 128;
    private final int CARDWIDTH = 64;

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
        camera.setToOrtho(false, RESOLUTIONWIDTH, RESOLUTIONHEIGHT);

        playerOne = new PlayerView();
        playerTwo = new PlayerView();
        
        playerOneCards = initialiseCardViews(battle.playerOne.cards);
        playerTwoCards = initialiseCardViews(battle.playerTwo.cards);
    }

    private Array<CardView> initialiseCardViews(Array<Card> cards){
        Array<CardView> cardViews = new Array<CardView>();

        for(Card card : cards){
            cardViews.add(new CardView(card.cardName));
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
        drawPlayerSprite(PlayerNumber.One, delta);
        drawPlayerCards(PlayerNumber.One);

        drawPlayerValues(PlayerNumber.Two);
        drawPlayerSprite(PlayerNumber.Two, delta);
        drawPlayerCards(PlayerNumber.Two);

        beatDemCards.batch.end();
    }

    private void resetScreen(){
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        camera.update();
        beatDemCards.batch.setProjectionMatrix(camera.combined);
    }

    private void drawPlayerValues(PlayerNumber playerNumber) {
        int startPositionX = playerNumber == PlayerNumber.One ? XPOSITIONPLAYERONE : XPOSITIONPLAYERTWO;
        int positionY = YPOSITION;
        int rowHeight = ROWHEIGHT;
        Player player = playerNumber == PlayerNumber.One ? battle.playerOne : battle.playerTwo;

        beatDemCards.bitmapFont.draw(beatDemCards.batch, PLAYER + String.valueOf(player.playerNo.toString()), startPositionX, positionY);
        positionY -= rowHeight;
        beatDemCards.bitmapFont.draw(beatDemCards.batch, HITPOINTS + String.valueOf(player.hitPoints), startPositionX, positionY);
        positionY -= rowHeight;
        beatDemCards.bitmapFont.draw(beatDemCards.batch, MOVEPOINTS + String.valueOf(player.hitPoints), startPositionX, positionY);
    }

    private void drawPlayerSprite(PlayerNumber playerNumber, float delta){
        TextureRegion currentFrame = playerNumber == PlayerNumber.One ? playerOne.getCurrentFrame(delta) : playerTwo.getCurrentFrame(delta);
        int xPosition = playerNumber == PlayerNumber.One ? XPOSITIONPLAYERONE : XPOSITIONPLAYERTWO;
        int yPosition = YPOSITION + 100;
        float width = playerNumber == PlayerNumber.One ? currentFrame.getRegionWidth() : -currentFrame.getRegionWidth();
        float height = currentFrame.getRegionHeight();

        beatDemCards.batch.draw(currentFrame, xPosition, yPosition, width, height);
    }

    private void drawPlayerCards(PlayerNumber playerNumber){
        Array<CardView> cardViews = playerNumber == PlayerNumber.One ? playerOneCards : playerTwoCards;
        int firstXPosition = playerNumber == PlayerNumber.One ? XPOSITIONPLAYERONE : XPOSITIONPLAYERTWO;
        firstXPosition -= 50;
        int offSet = 0;
        int offSetWidth = 125;
        int yPosition = 300;

        for(CardView currentCard : cardViews){
            beatDemCards.batch.draw(currentCard.CARDIMAGE, firstXPosition + offSet, yPosition, CARDHEIGHT, CARDWIDTH);
            offSet += offSetWidth;
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
