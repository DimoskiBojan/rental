package mk.ukim.finki.emt.renting.port.rest;

import mk.ukim.finki.emt.renting.application.RentCatalog;
import mk.ukim.finki.emt.renting.domain.model.*;
import mk.ukim.finki.emt.renting.domain.repository.ClientRepository;
import mk.ukim.finki.emt.renting.port.client.CdCatalogClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/rents")
public class RentCatatlogController {
    private final RentCatalog rentCatalog;

    public RentCatatlogController(RentCatalog rentCatalog, CdCatalogClient cdCatalogClient, ClientRepository clientRepository) {
        this.rentCatalog = rentCatalog;
    }

    @GetMapping
    public List<Rent> findAll() {
        return rentCatalog.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rent> findById(@PathVariable("id") String rentId) {
        return rentCatalog.findById(new RentId(rentId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RentId createRent(@RequestParam String clientId,
                             @RequestParam String cdId) {
        return rentCatalog.createRent(clientId, cdId);
    }

    @PutMapping("/{id}")
    public RentId returnRent(@PathVariable("id") String rentId) {
        return rentCatalog.returnRent(rentId);
    }
}
