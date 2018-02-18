package org.theoriok.crowncaps.service;

import org.theoriok.crowncaps.dto.CapDto;

import java.util.List;

public interface CapService {
    List<CapDto> findAllCaps();

    List<CapDto> findByCountryCode(String country);

    List<CapDto> findByCategoryName(String category);
}
