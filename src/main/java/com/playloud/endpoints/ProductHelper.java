package com.playloud.endpoints;

import com.playloud.dto.products.ProductsRequestDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.nio.file.Paths;

import static com.playloud.core.AppManager.CATEGORY_PATH;
import static com.playloud.core.AppManager.PRODUCTS_PATH;
import static io.restassured.RestAssured.given;

public class ProductHelper {

    public Response getCategories() {
        return given()
                .when()
                .get(CATEGORY_PATH);
    }

    public Response getProducts() {
        return given()
                .when()
                .get(PRODUCTS_PATH);
    }

    ProductsRequestDto product = new ProductsRequestDto(
            "Fender",
            "Antique thing",
            1000,
            false,
            Paths.get("/Users/baker/Tools/images.jpeg"),
            1
    );

    public Response addProduct(String accessToken) {
        return given()
                .header("Authorization", "Bearer " + accessToken)
                .contentType(ContentType.MULTIPART)
                .multiPart("title", this.product.title())
                .multiPart("description", this.product.description())
                .multiPart("price", this.product.price())
                .multiPart("isArchived", this.product.isArchived())
                .multiPart("file", this.product.file().toFile(), "image/jpeg")
                .multiPart("categoryId", this.product.categoryId())
                .when()
                .post(PRODUCTS_PATH);
    }
}
