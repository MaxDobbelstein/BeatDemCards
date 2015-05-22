/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.beat.dem.cards.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import de.beat.dem.cards.models.Card;

/**
 *
 * @author alex
 */

public class CardView {
    
    public final Texture cardImage;
    
    public CardView(String cardName){
        cardImage = new Texture(Gdx.files.internal(cardName +".png"));
    }
}