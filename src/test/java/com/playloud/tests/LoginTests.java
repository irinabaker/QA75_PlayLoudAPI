package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.login.LoginRequestDto;
import com.playloud.dto.login.LoginResponseDto;
import com.playloud.dto.users.ErrorListDto;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase {

    LoginRequestDto loginRequestDto = LoginRequestDto.of(
            EMAIL,
            PASSWORD
    );

    @Test
    public void loginSuccessTest() {
        LoginResponseDto loginDto = given()
                .contentType(ContentType.JSON)
                .body(loginRequestDto)
                .when()
                .post(LOGIN_PATH)
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(LoginResponseDto.class);

        System.out.println(loginDto.token());
        //eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VySWQiOjQ1LCJpYXQiOjE3NzE2MTU2NzMsImV4cCI6MTc3MTYxNjg3M30.43ytjtk7_juO7YZIkjI1gdhSu6CGipHoPeqr_4AlKF8
    }

    @Test
    public void loginWithWrongPasswordErrorTest() {
        //   ErrorListDto listDto =
        given()
                .contentType(ContentType.JSON)
                .body(LoginRequestDto.of(EMAIL, "Bernd"))
                .when()
                .post(LOGIN_PATH)
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("error", equalTo("Bad Request"))
        //     .extract().response().as(ErrorListDto.class)
        ;
        //   System.out.println(listDto.message() + " *** " + listDto.error());

    }
}
