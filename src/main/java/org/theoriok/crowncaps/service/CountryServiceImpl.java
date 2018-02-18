package org.theoriok.crowncaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theoriok.crowncaps.dto.CountryDto;
import org.theoriok.crowncaps.repository.CountryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private Converter converter;

    @Override
    public List<CountryDto> findAllCountries() {
        return countryRepository.findAll().stream()
                .map(country -> converter.map(country))
                .collect(Collectors.toList());
    }
}
