package org.theoriok.crowncaps.service;

import org.theoriok.crowncaps.dto.CountryDto;

import java.util.List;

public interface CountryService {
    List<CountryDto> findAllCountries();
}
