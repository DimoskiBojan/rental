package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Title;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Year;

@Entity
@Getter
@Table(name = "album")
public class Album extends AbstractEntity<AlbumId> {

    @Version
    private Long version;

    @Embedded
    private Title title;

    private Year releaseYear;

    public Album() {}

    public Album(AlbumId id, Title title, Year releaseYear) {
        super(id);
        this.title = title;
        this.releaseYear = releaseYear;
    }
}