package org.theoriok.crowncaps.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.theoriok.crowncaps.model.Category;
import org.theoriok.crowncaps.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("${rest.prefix}/categories")
public class CategoryResource {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> categories = categoryService.findAllCategories();
        return ResponseEntity.ok(categories);
    }
}
