package org.theoriok.crowncaps.service;

import org.theoriok.crowncaps.model.Cap;

import java.util.List;

public interface CapService {
    List<Cap> findAllCaps();

    List<Cap> findByCountryCode(String country);

    List<Cap> findByCategoryName(String category);
}
