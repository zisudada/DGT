package com.sukabing.DGT.Stages;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.sukabing.DGT.Constants;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.sukabing.DGT.DialogWindows;

public class CreateLoadGalStage extends Stage{
    
    Constants constants;
    Texture t1,t2;
    Image imgCreate,imgLoad;
    DialogWindows dialogWindows;
    public CreateLoadGalStage(){
        super();
        init();
    }

    void init(){
        dialogWindows = new DialogWindows();
        constants = new Constants();
        t1 = new Texture(Gdx.files.internal("png1.png"));
        t2 = new Texture(Gdx.files.internal("png2.png"));
        
        imgCreate = new Image(t1);
        imgLoad = new Image(t2);
        
        imgCreate.setWidth(constants.w()/4);
        imgCreate.setHeight(constants.h()/4);
        imgLoad.setWidth(constants.w()/4);
        imgLoad.setHeight(constants.h()/4);
        
        imgCreate.setPosition(constants.w()/2-imgCreate.getWidth()/2-imgCreate.getWidth(),constants.h()/2-imgCreate.getHeight()/2);
        imgLoad.setPosition(constants.w()/2-imgLoad.getWidth()/2+imgLoad.getWidth(),constants.h()/2-imgLoad.getHeight()/2);
        
        imgCreate.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    addActor(dialogWindows.win1());
                    return true;
                }
                
        });
        
        imgLoad.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    addActor(dialogWindows.win2());
                    //List -- choose project to load
                    /*
                    FileHandle[] files = Gdx.files.external("DiyGalTool").list();
                    FileHandle f = Gdx.files.external("a.txt");
                    for (FileHandle file:files){
                        if(file.exists()){
                            if (file.isDirectory()){
                                f.writeString("is dir",true);
                            }else{
                                f.writeString(file.readString(),true);
                            }
                        }else{
                            f.writeString("no exists",true);
                        }
                    }
                    */
                    return true;
                }
                
                
        });
        
        this.addActor(imgCreate);
        this.addActor(imgLoad);
        }
    
}
