package com.sukabing.linkingtheworld;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class MainActivity extends AndroidApplication {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        AndroidApplicationConfiguration cfg = new AndroidApplicationConfiguration();
        
        initialize(new MyGdxGame(), cfg);
    }
}
