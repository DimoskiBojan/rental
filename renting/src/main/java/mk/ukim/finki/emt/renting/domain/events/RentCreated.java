package mk.ukim.finki.emt.renting.domain.events;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.renting.domain.model.RentId;

import java.time.Instant;

@Getter
public class RentCreated implements DomainEvent {

    private final RentId rentId;

    private final Instant occuredOn;

    public RentCreated(RentId rentId, Instant occuredOn) {
        this.rentId = rentId;
        this.occuredOn = occuredOn;
    }

    @Override
    public Instant occurredOn() {
        return occuredOn;
    }
}
