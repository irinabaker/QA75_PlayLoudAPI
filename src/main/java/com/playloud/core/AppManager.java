package com.playloud.core;

import com.playloud.dto.login.LoginRequestDto;
import com.playloud.dto.products.ProductsRequestDto;
import com.playloud.dto.users.UsersRequestDto;
import com.playloud.endpoints.ProductHelper;
import com.playloud.endpoints.UserHelper;
import com.playloud.utils.PropertiesLoader;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class AppManager {

    public static final String NAME = PropertiesLoader.loadProperty("user.name");
    public static final String EMAIL = PropertiesLoader.loadProperty("user.email");
    public static final String PASSWORD = PropertiesLoader.loadProperty("user.password");
    public static final String USERS_PATH = PropertiesLoader.loadProperty("users.path");
    public static final String LOGIN_PATH = PropertiesLoader.loadProperty("login.path");
    public static final String CATEGORY_PATH = PropertiesLoader.loadProperty("category.path");
    public static final String PRODUCTS_PATH = PropertiesLoader.loadProperty("products.path");
    private static final String URI = PropertiesLoader.loadProperty("uri");
    private static final String PATH = PropertiesLoader.loadProperty("path");

    UserHelper user;
    ProductHelper product;

    public void start() {
        RestAssured.baseURI = URI;
        RestAssured.basePath = PATH;

        user = new UserHelper();
        product = new ProductHelper();
    }

    public UserHelper getUser() {
        return user;
    }

    public ProductHelper getProduct() {
        return product;
    }
}
