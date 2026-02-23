package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.products.AllProductsDto;
import com.playloud.dto.products.ProductsResponseDto;
import org.junit.jupiter.api.Test;

public class GetAllProductsTests extends TestBase {

    @Test
    public void getAllProductsSuccessTest() {
        AllProductsDto products = app.getProduct().getProducts()
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(AllProductsDto.class);

        for (ProductsResponseDto product: products.data()) {
            System.out.println(product.title());
            System.out.println(product.description());
            System.out.println(product.id());
            System.out.println(product.price());
            System.out.println(product.userId());
            System.out.println("**********************");
        }
        System.out.println("Size of list --> " + products.data().size());
    }

}
