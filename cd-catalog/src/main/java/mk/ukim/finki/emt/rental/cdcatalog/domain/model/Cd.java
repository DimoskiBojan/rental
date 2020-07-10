package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Title;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "cd")
public class Cd extends AbstractEntity<CdId> {

    @Version
    private Long version;

    @Embedded
    private Title title;

    @Embedded
    private Money price;

    private Boolean isAvailable;

    @ManyToOne
    private Artist artist;

    @ManyToOne
    private Album album;

    public Cd() {}

    public Cd(CdId id, Title title, Money price, Boolean isAvailable, Artist artist, Album album) {
        super(id);
        this.title = title;
        this.price = price;
        this.isAvailable = isAvailable;
        this.artist = artist;
        this.album = album;
    }

    public Cd(Title title, Money price, Boolean isAvailable, Artist artist, Album album) {
        this.title = title;
        this.price = price;
        this.isAvailable = isAvailable;
        this.artist = artist;
        this.album = album;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
