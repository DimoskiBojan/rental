package mk.ukim.finki.emt.rental.cdcatalog.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.CdId;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.RentId;
import mk.ukim.finki.emt.rental.cdcatalog.domain.model.RentItemId;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainEvent;

import java.time.Instant;

@Getter
public class RentItemAddedEvent implements DomainEvent {

    @JsonProperty("rentId")
    private final RentId rentId;

    @JsonProperty("rentItemId")
    private final RentItemId rentItemId;

    @JsonProperty("cdId")
    private final CdId cdId;

    @JsonProperty("occurredOn")
    private final Instant occurredOn;

    public RentItemAddedEvent(RentId rentId, RentItemId rentItemId, CdId cdId, Instant occurredOn) {
        this.rentId = rentId;
        this.rentItemId = rentItemId;
        this.cdId = cdId;
        this.occurredOn = occurredOn;
    }

    @Override
    public Instant occurredOn() {
        return occurredOn;
    }
}
