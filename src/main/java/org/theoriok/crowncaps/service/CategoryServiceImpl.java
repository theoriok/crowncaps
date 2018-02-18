package org.theoriok.crowncaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theoriok.crowncaps.dto.CategoryDto;
import org.theoriok.crowncaps.repository.CategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private Converter converter;

    @Override
    public List<CategoryDto> findAllCategories() {
        return categoryRepository.findAll().stream()
                .map(category -> converter.map(category))
                .collect(Collectors.toList());
    }
}
