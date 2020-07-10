package mk.ukim.finki.emt.rental.cdcatalog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentReturnedEventTranslator implements RemoteEventTranslator {
    private final ObjectMapper objectMapper;

    public RentReturnedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.renting.domain.events.RentReturned");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, RentReturnedEvent.class));
    }
}
