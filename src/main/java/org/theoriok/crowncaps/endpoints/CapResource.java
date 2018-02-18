package org.theoriok.crowncaps.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.theoriok.crowncaps.dto.CapDto;
import org.theoriok.crowncaps.service.CapService;

import java.util.List;

@RestController
@RequestMapping("${rest.prefix}/caps")
public class CapResource {
    @Autowired
    private CapService capService;

    @RequestMapping(
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<List<CapDto>> getCaps() {
        List<CapDto> caps = capService.findAllCaps();
        return ResponseEntity.ok(caps);
    }

    @RequestMapping(
            value = "country/{country}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<List<CapDto>> getCapsByCountry(@PathVariable(value = "country") String country) {
        List<CapDto> caps = capService.findByCountryCode(country);
        return ResponseEntity.ok(caps);
    }

    @RequestMapping(
            value = "category/{category}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            method = RequestMethod.GET
    )
    public ResponseEntity<List<CapDto>> getCapsByCategory(@PathVariable(value = "category") String category) {
        List<CapDto> caps = capService.findByCategoryName(category);
        return ResponseEntity.ok(caps);
    }
}
