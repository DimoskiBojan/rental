package mk.ukim.finki.emt.renting.domain.model;

import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RentId extends DomainObjectId {

    private RentId() {
        super(DomainObjectId.randomId(RentId.class).toString());
    }

    public RentId(String id) {
        super(id);
    }
}