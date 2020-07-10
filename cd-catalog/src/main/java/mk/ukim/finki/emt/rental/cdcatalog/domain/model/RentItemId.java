package mk.ukim.finki.emt.rental.cdcatalog.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;

public class RentItemId extends DomainObjectId {

    @JsonCreator
    public RentItemId(String id) {
        super(id);
    }
}
