package com.sukabing.linkingtheworld.Stages;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.AlphaAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sukabing.linkingtheworld.Constants;

public class MainStage extends Stage{
    Constants c;
    Texture t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Image avatar,local_network,chat,figures,mods,stand,settings,shop,announcement,bg;
    Group group1;
    SequenceAction sequence1;
    AlphaAction alpha1,alpha2;
    
    Texture t_bg;
    Image ok,cancel,show;
    Window dialogWinow;
    BitmapFont font;
    
    public MainStage(){
        super();
        
        ok = new Image(new Texture(Gdx.files.internal("main_stage_res/ok.jpg")));
        ok.setSize(100,100);
        ok.setPosition(0,0);
        cancel = new Image(new Texture(Gdx.files.internal("main_stage_res/cancel.jpg")));
        cancel.setSize(100,100);
        cancel.setPosition(200,0);
        show =  new Image(new Texture(Gdx.files.internal("main_stage_res/show.jpg")));
        show.setSize(100,100);
        show.setPosition(100,100);
        t_bg = new Texture(Gdx.files.internal("main_stage_res/bg.jpg"));
        font = new BitmapFont();
        TextureRegionDrawable windowDrawable = new TextureRegionDrawable(new TextureRegion(t_bg));
        Window.WindowStyle stlye = new Window.WindowStyle(font,Color.RED,windowDrawable);
        dialogWinow = new Window("window",stlye);

        dialogWinow.setSize(Gdx.graphics.getWidth()/2,Gdx.graphics.getHeight()/2);
        dialogWinow.setModal(true);

        ok.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        cancel.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    dialogWinow.remove();
                    return true;
                }

            });
            /*
        show.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    addActor(dialogWinow);
                    return true;
                }

            });
*/
        dialogWinow.addActor(ok);
        dialogWinow.addActor(cancel);
        //this.addActor(show);
        
        
        init();
    }
    
    void init(){
        group1 = new Group();
        t1 = new Texture(Gdx.files.internal("main_stage_res/avatar.jpg"));
        t2 = new Texture(Gdx.files.internal("main_stage_res/local_network.png"));
        t3 = new Texture(Gdx.files.internal("main_stage_res/chat.png"));
        t4 = new Texture(Gdx.files.internal("main_stage_res/figures.png"));
        t5 = new Texture(Gdx.files.internal("main_stage_res/mods.png"));
        t6 = new Texture(Gdx.files.internal("main_stage_res/nggyu.jpeg"));
        t7 = new Texture(Gdx.files.internal("main_stage_res/settings.png"));
        t8 = new Texture(Gdx.files.internal("main_stage_res/shop.png"));
        t9 = new Texture(Gdx.files.internal("main_stage_res/announcement.png"));
        t10 = new Texture(Gdx.files.internal("main_stage_res/main_stage_bg.png"));
        avatar = new Image(t1);
        local_network = new Image(t2);
        chat = new Image(t3);
        figures = new Image(t4);
        mods = new Image(t5);
        stand = new Image(t6);
        settings = new Image(t7);
        shop = new Image(t8);
        announcement = new Image(t9);
        bg = new Image(t10);
        
        avatar.setSize(c.h()/5,c.h()/5);
        avatar.setPosition(0,c.h()-avatar.getHeight());
        avatar.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }
                
        });
        //左下
        local_network.setSize(c.h()/4,c.h()/4);
        local_network.setPosition(local_network.getWidth(),c.h()/2-local_network.getHeight());
        local_network.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    //Gdx.app.exit();
                    addActor(dialogWinow);
                    return true;
                }

            });
        //左上
        chat.setSize(c.h()/4,c.h()/4);
        chat.setPosition(chat.getWidth(),c.h()/2);
        chat.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //右下
        figures.setSize(c.h()/4,c.h()/4);
        figures.setPosition(c.w()-figures.getWidth()*2,c.h()/2-figures.getHeight());
        figures.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //上
        mods.setSize(c.h()/4,c.h()/4);
        mods.setPosition(c.w()-chat.getWidth()*2,c.h()/2);
        mods.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //立绘 看板
        stand.setSize(c.w()/3,c.h()/6*5);
        stand.setPosition(c.w()/2-stand.getWidth()/2,0);
        
        //设置 右下
        settings.setSize(c.h()/6,c.h()/6);
        settings.setPosition(c.w()-settings.getWidth(),0);
        
        //商店 左下
        shop.setSize(c.h()/6,c.h()/6);
        shop.setPosition(0,0);
        
        //公告 右上
        announcement.setSize(c.h()/6,c.h()/6);
        announcement.setPosition(c.w()-announcement.getWidth(),c.h()-announcement.getHeight());
        
        //背景
        bg.setSize(c.w(),c.h());
        
        group1.addActor(bg);
        group1.addActor(avatar);
        group1.addActor(local_network);
        group1.addActor(chat);
        group1.addActor(figures);
        group1.addActor(mods);
        group1.addActor(stand);
        group1.addActor(settings);
        group1.addActor(shop);
        group1.addActor(announcement);
        
        alpha1 = Actions.alpha(0);
        alpha2 = Actions.fadeIn(1);
        sequence1 = Actions.sequence(alpha1,alpha2);
        group1.addAction(sequence1);
        this.addActor(group1);
        
        
        
    }
}
