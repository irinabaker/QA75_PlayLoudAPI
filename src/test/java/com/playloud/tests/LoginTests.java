package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.login.LoginRequestDto;
import com.playloud.dto.login.LoginResponseDto;
import org.junit.jupiter.api.Test;

import static com.playloud.core.AppManager.EMAIL;
import static com.playloud.core.AppManager.PASSWORD;
import static org.hamcrest.Matchers.equalTo;

public class LoginTests extends TestBase {

    LoginRequestDto loginRequestDto = LoginRequestDto.of(
            EMAIL,
            PASSWORD
    );

    @Test
    public void loginSuccessTest() {
        LoginResponseDto loginDto = app.getUser().login(loginRequestDto)
                .then()
                .assertThat().statusCode(201)
                .extract().response().as(LoginResponseDto.class);

        System.out.println(loginDto.token());
    }


    @Test
    public void loginWithWrongPasswordErrorTest() {
        //   ErrorListDto listDto =
        app.getUser().login(LoginRequestDto.of(EMAIL, "Bernd"))
                .then()
                .assertThat().statusCode(400)
                .assertThat().body("error", equalTo("Bad Request"))
            // .extract().response().as(ErrorListDto.class)
        ;
         //  System.out.println(listDto.message() + " *** " + listDto.error());
    }
}
