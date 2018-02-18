package org.theoriok.crowncaps.service;

import org.theoriok.crowncaps.dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    List<CategoryDto> findAllCategories();
}
