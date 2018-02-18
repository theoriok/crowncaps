package org.theoriok.crowncaps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.theoriok.crowncaps.model.Cap;
import org.theoriok.crowncaps.repository.CapRepository;

import java.util.List;

@Service
public class CapServiceImpl implements CapService {

    @Autowired
    private CapRepository capRepository;

    @Override
    public List<Cap> findAllCaps() {
        return capRepository.findAll();
    }

    @Override
    public List<Cap> findByCountryCode(String country) {
        return capRepository.findAllByCountry_CodeIgnoreCase(country);
    }

    @Override
    public List<Cap> findByCategoryName(String category) {
        return capRepository.findAllByCategories_NameIgnoreCase(category);
    }
}
