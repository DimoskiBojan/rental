package mk.ukim.finki.emt.renting.domain.model;

import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class RentItemId extends DomainObjectId {

    private RentItemId() {
        super(DomainObjectId.randomId(RentItemId.class).toString());
    }

    public RentItemId(String id) {
        super(id);
    }
}
