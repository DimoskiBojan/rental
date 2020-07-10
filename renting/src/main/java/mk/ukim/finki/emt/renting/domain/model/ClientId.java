package mk.ukim.finki.emt.renting.domain.model;

import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class ClientId extends DomainObjectId {

    private ClientId() {
        super(DomainObjectId.randomId(ClientId.class).toString());
    }

    public ClientId(String id) {
        super(id);
    }
}
