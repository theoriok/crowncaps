package org.theoriok.crowncaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theoriok.crowncaps.dto.CapDto;
import org.theoriok.crowncaps.repository.CapRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapServiceImpl implements CapService {

    @Autowired
    private CapRepository capRepository;

    @Autowired
    private Converter converter;

    @Override
    public List<CapDto> findAllCaps() {
        return capRepository.findAll().stream()
                .map(cap -> converter.map(cap))
                .collect(Collectors.toList());
    }

    @Override
    public List<CapDto> findByCountryCode(String country) {
        return capRepository.findAllByCountry_CodeIgnoreCase(country).stream()
                .map(cap -> converter.map(cap))
                .collect(Collectors.toList());
    }

    @Override
    public List<CapDto> findByCategoryName(String category) {
        return capRepository.findAllByCategories_NameIgnoreCase(category).stream()
                .map(cap -> converter.map(cap))
                .collect(Collectors.toList());
    }
}
