package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.login.LoginRequestDto;
import com.playloud.dto.products.ProductsResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.playloud.core.AppManager.EMAIL;
import static com.playloud.core.AppManager.PASSWORD;
import static org.hamcrest.Matchers.equalTo;

public class AddProductTests extends TestBase {

    String token;

    @BeforeEach
    public void precondition() {
        String responseToken = app.getUser().login(LoginRequestDto.of(EMAIL, PASSWORD))
                .then()
                .extract().body().path("accessToken");
        token = responseToken;
        System.out.println(token);
    }

    @Test
    public void addProductSuccessTest() {
        ProductsResponseDto product = app.getProduct().addProduct(token)
                .then()
                .log().all()
                .assertThat().statusCode(201)
                .assertThat().body("title", equalTo("Fender"))
                .extract().as(ProductsResponseDto.class);

        System.out.println(product.id() + " *** " + product.title());
    }

}
