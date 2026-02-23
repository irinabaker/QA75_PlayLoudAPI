package com.playloud.endpoints;

import com.playloud.dto.login.LoginRequestDto;
import com.playloud.dto.users.UsersRequestDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.playloud.core.AppManager.LOGIN_PATH;
import static com.playloud.core.AppManager.USERS_PATH;
import static io.restassured.RestAssured.given;

public class UserHelper {

    public Response register(UsersRequestDto registerDto) {
        return given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(registerDto)
                .when()
                .post(USERS_PATH);
    }

    public Response login(LoginRequestDto loginDto) {
        return given()
                .contentType(ContentType.JSON)
                .body(loginDto)
                .when()
                .post(LOGIN_PATH);
    }
}
