package com.sukabing.linkingtheworld.Stages;
import android.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

public class GameStage extends Stage{
    SpriteBatch batch;
    TextField tf_gettext;
    BitmapFont font;
    public GameStage(){
        super();
        init();
    }
    
    void init(){
        batch = new SpriteBatch();
        font = new BitmapFont();
        font.scale(3);
        font.setColor(Color.RED);
        batch.begin();
        font.draw(batch,"999",100,100);
        batch.end();
        
    }
}
