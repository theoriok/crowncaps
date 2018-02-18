package org.theoriok.crowncaps.service;

import org.theoriok.crowncaps.dto.CapDto;
import org.theoriok.crowncaps.dto.CategoryDto;
import org.theoriok.crowncaps.dto.CountryDto;
import org.theoriok.crowncaps.model.Cap;
import org.theoriok.crowncaps.model.Category;
import org.theoriok.crowncaps.model.Country;

public interface Converter {
    CapDto map(Cap cap);

    CountryDto map(Country country);

    CategoryDto map(Category category);
}
