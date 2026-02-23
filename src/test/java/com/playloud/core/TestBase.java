package com.playloud.core;

import com.playloud.utils.MyTestWatcher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MyTestWatcher.class)
public class TestBase {

    protected AppManager app = new AppManager();

    @BeforeEach
    public void init() {
        app.start();
    }
}
