package com.playloud.core;

import com.playloud.utils.PropertiesLoader;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {

    private static final String URI = PropertiesLoader.loadProperty("uri");
    private static final String PATH = PropertiesLoader.loadProperty("path");

    public static final String NAME = PropertiesLoader.loadProperty("user.name");
    public static final String EMAIL = PropertiesLoader.loadProperty("user.email");
    public static final String PASSWORD = PropertiesLoader.loadProperty("user.password");

    public static final String USERS_PATH = PropertiesLoader.loadProperty("users.path");
    public static final String LOGIN_PATH = PropertiesLoader.loadProperty("login.path");

    @BeforeEach
    public void init() {
        RestAssured.baseURI = URI;
        RestAssured.basePath = PATH;
    }
}
