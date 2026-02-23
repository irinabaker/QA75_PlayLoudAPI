package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.users.ErrorDto;
import com.playloud.dto.users.ErrorListDto;
import com.playloud.dto.users.UsersRequestDto;
import com.playloud.dto.users.UsersResponseDto;
import org.junit.jupiter.api.Test;

import static com.playloud.core.AppManager.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class CreateAccountTests extends TestBase {

    UsersRequestDto requestDto = UsersRequestDto
            .of(NAME,"bernd" + System.currentTimeMillis() + "@gm.com",PASSWORD);

    @Test
    public void createAccountSuccessTest() {
        UsersResponseDto responseDto = app.getUser().register(requestDto)
                .then()
                .assertThat().statusCode(201)
                .assertThat().body("name",equalTo(NAME))
                .extract().response().as(UsersResponseDto.class);

        System.out.println(responseDto.id() + " *** " + responseDto.name());
    }

    @Test
    public void createExistedEmailErrorTest() {
        ErrorDto errorDto = app.getUser().register(UsersRequestDto.of(NAME, EMAIL, PASSWORD))
                .then()
                .assertThat().statusCode(409)
                .assertThat().body("message",containsString("email already exists"))
                .extract().response().as(ErrorDto.class);

        System.out.println(errorDto.error() + " *** " + errorDto.message());
        //P2002 *** A record with this email already exists.
    }

    @Test
    public void createAccountWithInvalidPasswordErrorTest() {
        ErrorListDto errorDto = app.getUser().register(UsersRequestDto.of(NAME,
                "test" + System.currentTimeMillis() + "@.gm.com",
                "1234"))
                .then()
                .log().all()
                .assertThat().statusCode(400)
                .assertThat().body("error",equalTo("Bad Request"))
                .extract().response().as(ErrorListDto.class);

        System.out.println(errorDto.error() + " *** " + errorDto.message());

        //Bad Request *** [password must be longer than or equal to 6 characters]
    }
}
