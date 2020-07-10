package mk.ukim.finki.emt.rental.cdcatalog;

import mk.ukim.finki.emt.rental.cdcatalog.domain.model.*;
import mk.ukim.finki.emt.rental.cdcatalog.domain.repository.AlbumRepository;
import mk.ukim.finki.emt.rental.cdcatalog.domain.repository.ArtistRepository;
import mk.ukim.finki.emt.rental.cdcatalog.domain.repository.CdRepository;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.Country;
import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.FullName;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Genre;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Title;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.time.Year;
import java.util.ArrayList;

@Component
public class DataGenerator {
    private final CdRepository cdRepository;
    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public DataGenerator(CdRepository cdRepository, ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.cdRepository = cdRepository;
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        if (cdRepository.findAll().size()==0) {
            Artist artist = new Artist(new ArtistId("1"), new FullName("Abel", "Tesfaye"), Country.USA, Genre.Pop);
            Album album = new Album(new AlbumId("1"), new Title("Blinding Lights"), Year.of(2019));
            artistRepository.save(artist);
            albumRepository.save(album);

            var cds = new ArrayList<Cd>();
            cds.add(createProduct(new CdId("1"),new Title("Blinding Lights"),  new Money(Currency.MKD, 600),true, artist, album));
            cds.add(createProduct(new CdId("2"),new Title("Heartless"),  new Money(Currency.MKD, 500),true, artist, album));
            cdRepository.saveAll(cds);
        }

    }

    private Cd createProduct(CdId cdId, Title title, Money price, Boolean isAvailable, Artist artist, Album album) {
        var cd = new Cd(cdId, title, price, isAvailable, artist, album);
        return cd;
    }
}
