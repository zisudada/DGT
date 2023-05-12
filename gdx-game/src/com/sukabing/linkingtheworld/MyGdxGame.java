package com.sukabing.linkingtheworld;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.sukabing.linkingtheworld.Stages.MainStage;

public class MyGdxGame implements ApplicationListener
{
	MainStage mainstage;
    Constants c;
    
    
	@Override
	public void create()
	{
		mainstage = new MainStage();
	}
    
    void change_stage(){
        switch(c.StageFlag){
            case c.MainStage:
                mainstage.act();
                mainstage.draw();
                Gdx.input.setInputProcessor(mainstage);
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
