package mk.ukim.finki.emt.rental.cdcatalog.domain.repository;

import mk.ukim.finki.emt.rental.cdcatalog.domain.model.Cd;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.CdId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CdRepository extends JpaRepository<Cd, CdId> {
}
