package com.sukabing.DGT;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.sukabing.DGT.Stages.CreateLoadGalStage;

public class MyGdxGame implements ApplicationListener
{
	CreateLoadGalStage createLoadGalStage;
    Constants constants;
	@Override
	public void create()
	{
		constants = new Constants();
        createLoadGalStage = new CreateLoadGalStage();
	}

	@Override
	public void render()
	{        
	    Gdx.gl.glClearColor(0, 0, 0, 1);
	    Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		choosestage();
	}

    //chooose stage
    
    void choosestage(){
        switch(constants.StageFlag){
            case constants.CreateLoadGalStageFlag:
                createLoadGalStage.act();
                createLoadGalStage.draw();
                Gdx.input.setInputProcessor(createLoadGalStage);
        }
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
