package com.sukabing.DGT;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class DialogWindows {
    Constants constants;
    //CreateGalWindow
    public Window win1() {
        BitmapFont bmf1 = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
        Window.WindowStyle ws = new Window.WindowStyle(bmf1, Color.RED, new TextureRegionDrawable(new TextureRegion(new Texture("png3.png"))));
        final Window w = new Window("", ws);
        w.setWidth(constants.w() / 4 * 3);
        w.setHeight(constants.h() / 4 * 3);
        w.setPosition(constants.w() / 2 - constants.w() / 4 * 3 / 2, constants.h() / 2 - constants.h() / 4 * 3 / 2);
        w.setModal(true);
        return w;
    }

    public Window win2() {
        BitmapFont bmf1 = new BitmapFont(Gdx.files.internal("font.fnt"), Gdx.files.internal("font.png"), false);
        Window.WindowStyle ws = new Window.WindowStyle(bmf1, Color.RED, new TextureRegionDrawable(new TextureRegion(new Texture("png4.png"))));
        final Window w = new Window("", ws);
        w.setWidth(constants.w() / 4 * 3);
        w.setHeight(constants.h() / 4 * 3);
        w.setPosition(constants.w() / 2 - constants.w() / 4 * 3 / 2, constants.h() / 2 - constants.h() / 4 * 3 / 2);
        w.setModal(true);
        Image ok = new Image(new Texture("png1.png"));
        Image cancel = new Image(new Texture("png2.png"));
        ok.setWidth(constants.w()/6);
        ok.setHeight(constants.h()/6);
        ok.setPosition(0,0);
        ok.addListener(new InputListener(){
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    Gdx.app.exit();
                    return true;
                }
                
        });
        cancel.setWidth(constants.w()/6);
        cancel.setHeight(constants.h()/6);
        cancel.setPosition(w.getWidth()-constants.w()/6,0);
        cancel.addListener(new InputListener(){
                public boolean touchDown(com.badlogic.gdx.scenes.scene2d.InputEvent event, float x, float y, int pointer, int button) {
                    w.remove();
                    return true;
                }
                
        });
        
        w.addActor(ok);
        w.addActor(cancel);
//        list the dir name 
        /*
        FileHandle[] files = Gdx.files.external("DiyGalTool").list();
        FileHandle f = Gdx.files.external("a.txt");
        for (FileHandle file:files) {
            if (file.exists()) {
                if (file.isDirectory()) {
                    f.writeString("is dir", true);
                } else {
                    f.writeString(file.readString(), true);
                }
            } else {
                f.writeString("no exists", true);
            }
        }*/

        return w;
    }

}
