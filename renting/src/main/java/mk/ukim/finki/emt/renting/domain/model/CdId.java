package mk.ukim.finki.emt.renting.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class CdId extends DomainObjectId {

    private CdId() {
        super(DomainObjectId.randomId(CdId.class).toString());
    }

    @JsonCreator
    public CdId(String id) {
        super(id);
    }

}