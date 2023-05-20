package com.sukabing.linkingtheworld;

import android.graphics.Color;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.sukabing.linkingtheworld.Stages.GameStage;
import com.sukabing.linkingtheworld.Stages.MainStage;

public class MyGdxGame implements ApplicationListener
{
	MainStage mainstage;
    GameStage gamestage;
    Constants c;
    SpriteBatch batch;
    BitmapFont font;
    
	@Override
	public void create()
	{
		mainstage = new MainStage();
        gamestage = new GameStage();
	}
    
    void change_stage(){
        switch(c.StageFlag){
            case c.MainStage:
                mainstage.act();
                mainstage.draw();
                Gdx.input.setInputProcessor(mainstage);
                break;
            case c.GameStage:
                batch = new SpriteBatch();
                font = new BitmapFont();
                font.scale(3);
                font.setColor(Color.RED);
                batch.begin();
                font.draw(batch,"999",100,100);
                batch.end();
                break;
        }
    }
    
	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		change_stage();
	}

	@Override
	public void dispose()
	{
	}

	@Override
	public void resize(int width, int height)
	{
	}

	@Override
	public void pause()
	{
	}

	@Override
	public void resume()
	{
	}
}
