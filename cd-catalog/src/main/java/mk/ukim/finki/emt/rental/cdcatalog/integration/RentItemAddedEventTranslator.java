package mk.ukim.finki.emt.rental.cdcatalog.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainEvent;
import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.RemoteEventTranslator;
import mk.ukim.finki.emt.rental.sharedkernel.infra.eventlog.StoredDomainEvent;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RentItemAddedEventTranslator implements RemoteEventTranslator {

    private final ObjectMapper objectMapper;

    public RentItemAddedEventTranslator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public boolean supports(StoredDomainEvent storedDomainEvent) {
        return storedDomainEvent.domainEventClassName().equals("mk.ukim.finki.emt.renting.domain.events.RentItemAdded");
    }

    @Override
    public Optional<DomainEvent> translate(StoredDomainEvent remoteEvent) {
        return Optional.of(remoteEvent.toDomainEvent(objectMapper, RentItemAddedEvent.class));
    }
}
