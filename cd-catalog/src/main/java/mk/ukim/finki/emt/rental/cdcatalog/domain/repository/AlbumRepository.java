package mk.ukim.finki.emt.rental.cdcatalog.domain.repository;

import mk.ukim.finki.emt.rental.cdcatalog.domain.model.Album;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.AlbumId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, AlbumId> {
}
