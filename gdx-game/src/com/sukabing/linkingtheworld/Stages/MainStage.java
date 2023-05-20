package com.sukabing.linkingtheworld.Stages;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
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
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.sukabing.linkingtheworld.Constants;

public class MainStage extends Stage {
    Constants c;
    Texture t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
    Image avatar,local_network,chat,figures,mods,stand,settings,shop,announcement,bg;
    Group group1;
    SequenceAction sequence1;
    AlphaAction alpha1,alpha2;

    Texture j_c_serverWindow_bg;
    Image join_server,cancel,create_server;
    Window j_c_serverWindow;
    BitmapFont font;
    
    //创建房间 t11-背景 t12-光标
    Texture t11,t12;
    TextField tf_server_name;
    TextField tf_player_num;

    public MainStage() {
        super();
        init();
        //Todo: 移植window去另一个类
        window1();
        window1_create_server();
    }
    
    //加入/创建服务器界面-创建服务器界面
    void window1_create_server(){
        t11 = new Texture(Gdx.files.internal("test_block.png"));
        TextField.TextFieldStyle tf_style = new TextField.TextFieldStyle();
        tf_style.background = new TextureRegionDrawable(new TextureRegion(t11));
        tf_style.font = font;
        //Texture cursorTexture = createCursorTexture();
        //tf_style.fontColor = new Color(1,1 1,1);
        tf_style.fontColor = new Color(0, 0, 0, 1);
		//tf_style.cursor = new TextureRegionDrawable(new TextureRegion(cursorTexture));
		
        tf_server_name = new TextField("",tf_style);
        tf_player_num = new TextField("",tf_style);
        tf_server_name.setText("=====");
        tf_server_name.setSize(j_c_serverWindow.getWidth()/2,j_c_serverWindow.getHeight()/2);
        tf_server_name.setPosition(0,0);
        tf_player_num.setText("=====");
        tf_player_num.setSize(j_c_serverWindow.getWidth()/2,j_c_serverWindow.getHeight()/2);
        tf_player_num.setPosition(0,100);
        j_c_serverWindow.addActor(tf_player_num);
        j_c_serverWindow.addActor(tf_server_name);
        
    }
    
    Texture createCursorTexture() {
        Pixmap pixmap = new Pixmap(1, 200 - 4, Pixmap.Format.RGBA8888);
        pixmap.setColor(1, 0, 0, 1);
        pixmap.fill();
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        return texture;
	}
    
    //加入/创建服务器界面
    void window1() {
        j_c_serverWindow_bg = new Texture(Gdx.files.internal("main_stage_res/bg.jpg"));
        font = new BitmapFont();
        TextureRegionDrawable windowDrawable = new TextureRegionDrawable(new TextureRegion(j_c_serverWindow_bg));
        Window.WindowStyle stlye = new Window.WindowStyle(font, Color.RED, windowDrawable);
        j_c_serverWindow = new Window("window", stlye);

        j_c_serverWindow.setSize(c.w() / 5 * 3, c.h() / 5 * 4);
        j_c_serverWindow.setPosition(c.w() / 2 - j_c_serverWindow.getWidth() / 2, c.h() / 2 - j_c_serverWindow.getHeight() / 2);
        j_c_serverWindow.setModal(true);

        join_server = new Image(new Texture(Gdx.files.internal("main_stage_res/join_server.png")));
        join_server.setSize(100, 100);
        join_server.setPosition(0, 0);
        cancel = new Image(new Texture(Gdx.files.internal("main_stage_res/cancel.png")));
        cancel.setSize(100, 100);
        cancel.setPosition(j_c_serverWindow.getWidth() - 100, j_c_serverWindow.getHeight() - 100);
        create_server = new Image(new Texture(Gdx.files.internal("main_stage_res/create_server.png")));
        create_server.setSize(100, 100);
        create_server.setPosition(j_c_serverWindow.getWidth() - 100, 0);


        join_server.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        cancel.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    j_c_serverWindow.remove();
                    return true;
                }

            });
        create_server.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    /*if(tf_server_name.getText().equals("ok")){
                        Gdx.app.exit();
                    }*/
                    c.StageFlag = c.GameStage;
                    return true;
                }

            });
        j_c_serverWindow.addActor(join_server);
        j_c_serverWindow.addActor(cancel);
        j_c_serverWindow.addActor(create_server);

    }
    void init() {
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

        avatar.setSize(c.h() / 5, c.h() / 5);
        avatar.setPosition(0, c.h() - avatar.getHeight());
        avatar.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //左下
        local_network.setSize(c.h() / 4, c.h() / 4);
        local_network.setPosition(local_network.getWidth(), c.h() / 2 - local_network.getHeight());
        local_network.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    //j_c_serverWindow.addAction(sequence1);
                    addActor(j_c_serverWindow);
                    
                    return true;
                }

            });
        //左上
        chat.setSize(c.h() / 4, c.h() / 4);
        chat.setPosition(chat.getWidth(), c.h() / 2);
        chat.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //右下
        figures.setSize(c.h() / 4, c.h() / 4);
        figures.setPosition(c.w() - figures.getWidth() * 2, c.h() / 2 - figures.getHeight());
        figures.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //上
        mods.setSize(c.h() / 4, c.h() / 4);
        mods.setPosition(c.w() - chat.getWidth() * 2, c.h() / 2);
        mods.addListener(new InputListener(){
                public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }

            });
        //立绘 看板
        stand.setSize(c.w() / 3, c.h() / 6 * 5);
        stand.setPosition(c.w() / 2 - stand.getWidth() / 2, 0);

        //设置 右下
        settings.setSize(c.h() / 6, c.h() / 6);
        settings.setPosition(c.w() - settings.getWidth(), 0);

        //商店 左下
        shop.setSize(c.h() / 6, c.h() / 6);
        shop.setPosition(0, 0);

        //公告 右上
        announcement.setSize(c.h() / 6, c.h() / 6);
        announcement.setPosition(c.w() - announcement.getWidth(), c.h() - announcement.getHeight());

        //背景
        bg.setSize(c.w(), c.h());

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
        sequence1 = Actions.sequence(alpha1, alpha2);
        group1.addAction(sequence1);
        this.addActor(group1);



    }
}
