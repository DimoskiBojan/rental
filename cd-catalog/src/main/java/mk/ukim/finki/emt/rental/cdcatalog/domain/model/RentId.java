package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

public class RentId extends DomainObjectId {

    @JsonCreator
    public RentId(String id) {
        super(id);
    }
}