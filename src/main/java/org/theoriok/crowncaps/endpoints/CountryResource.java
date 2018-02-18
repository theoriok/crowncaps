package org.theoriok.crowncaps.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.theoriok.crowncaps.dto.CountryDto;
import org.theoriok.crowncaps.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("${rest.prefix}/countries")
public class CountryResource {
    @Autowired
    private CountryService countryService;

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<List<CountryDto>> getCountries() {
        List<CountryDto> countries = countryService.findAllCountries();
        return ResponseEntity.ok(countries);
    }

}
