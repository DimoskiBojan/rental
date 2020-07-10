package mk.ukim.finki.emt.rental.cdcatalog.port.rest;

import mk.ukim.finki.emt.rental.cdcatalog.application.CdCatalog;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.Cd;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.CdId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cds")
public class CdCatalogController {
    private final CdCatalog cdCatalog;

    public CdCatalogController(CdCatalog cdCatalog) {
        this.cdCatalog = cdCatalog;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cd> findById(@PathVariable("id") String cdId) {
        return cdCatalog.findById(new CdId(cdId))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Cd> findAll() {
        return cdCatalog.findAll();
    }
}
