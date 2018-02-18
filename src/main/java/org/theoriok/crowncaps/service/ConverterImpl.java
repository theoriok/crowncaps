package org.theoriok.crowncaps.service;

import org.springframework.stereotype.Service;
import org.theoriok.crowncaps.dto.CapDto;
import org.theoriok.crowncaps.dto.CategoryDto;
import org.theoriok.crowncaps.dto.CountryDto;
import org.theoriok.crowncaps.model.Cap;
import org.theoriok.crowncaps.model.Category;
import org.theoriok.crowncaps.model.Country;

import java.util.stream.Collectors;

@Service
public class ConverterImpl implements Converter {
    @Override
    public CapDto map(Cap cap) {
        CapDto capDto = new CapDto();
        capDto.setId(cap.getSid());
        capDto.setAmount(cap.getAmount());
        capDto.setName(cap.getName());
        capDto.setDescription(cap.getDescription());
        capDto.setCountry(map(cap.getCountry()));
        capDto.setCategories(cap.getCategories().stream()
                .map(this::map)
                .collect(Collectors.toSet()));
        return capDto;
    }

    @Override
    public CountryDto map(Country country) {
        CountryDto countryDto = new CountryDto();
        countryDto.setId(country.getSid());
        countryDto.setCode(country.getCode());
        countryDto.setName(country.getName());
        return countryDto;
    }

    @Override
    public CategoryDto map(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(category.getSid());
        categoryDto.setDescription(category.getDescription());
        categoryDto.setName(category.getName());
        return categoryDto;
    }
}
