package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ArtistId extends DomainObjectId {

    private ArtistId() {
        super(DomainObjectId.randomId(ArtistId.class).toString());
    }

    @JsonCreator
    public ArtistId(String id) {
        super(id);
    }
}
