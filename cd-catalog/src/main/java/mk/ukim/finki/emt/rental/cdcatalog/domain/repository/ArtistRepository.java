package mk.ukim.finki.emt.rental.cdcatalog.domain.repository;

import mk.ukim.finki.emt.rental.cdcatalog.domain.model.Artist;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.ArtistId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist, ArtistId> {
}
