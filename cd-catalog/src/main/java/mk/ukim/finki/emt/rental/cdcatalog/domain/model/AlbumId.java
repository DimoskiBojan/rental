package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class AlbumId extends DomainObjectId {

    private AlbumId() {
        super(DomainObjectId.randomId(AlbumId.class).toString());
    }

    @JsonCreator
    public AlbumId(String id) {
        super(id);
    }
}
