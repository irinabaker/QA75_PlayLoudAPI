package com.playloud.tests;

import com.playloud.core.TestBase;
import com.playloud.dto.category.CategoryResponseDto;
import org.junit.jupiter.api.Test;

public class GetAllCategoriesTests extends TestBase {

    @Test
    public void getAllCategoriesSuccessTest() {
        CategoryResponseDto[] categories = app.getProduct().getCategories()
                .then()
                .assertThat().statusCode(200)
                .extract().response().as(CategoryResponseDto[].class);

        for (CategoryResponseDto c: categories) {
            System.out.println(c.id() + " *** " + c.title() + " *** " + c.slug());
            System.out.println(categories.length);
        }
    }

}
