package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.Country;
import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.FullName;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Genre;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "artist")
public class Artist extends AbstractEntity<ArtistId> {

    @Version
    private Long version;

    @Embedded
    private FullName name;

    @Enumerated(EnumType.STRING)
    private Country country;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    public Artist() {}

    public Artist(ArtistId id, FullName name, Country country, Genre genre) {
        super(id);
        this.name = name;
        this.country = country;
        this.genre = genre;
    }
}
