package org.theoriok.crowncaps.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.theoriok.crowncaps.model.Cap;

import java.util.List;

@Repository
public interface CapRepository extends CrudRepository<Cap, Integer> {
    List<Cap> findAll();

    List<Cap> findAllByCountry_CodeIgnoreCase(String country);

    List<Cap> findAllByCategories_NameIgnoreCase(String category);
}
