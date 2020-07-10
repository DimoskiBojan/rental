package mk.ukim.finki.emt.renting.application;

import mk.ukim.finki.emt.renting.domain.events.RentCreated;
import mk.ukim.finki.emt.renting.domain.events.RentItemAdded;
import mk.ukim.finki.emt.renting.domain.exceptions.ClientNotFoundException;
import mk.ukim.finki.emt.renting.domain.model.*;
import mk.ukim.finki.emt.renting.domain.repository.ClientRepository;
import mk.ukim.finki.emt.renting.domain.repository.RentRepository;
import mk.ukim.finki.emt.renting.domain.service.RentService;
import mk.ukim.finki.emt.renting.port.client.CdCatalogClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class RentCatalog {
    private final RentRepository rentRepository;
    private final RentService rentService;
    private final ClientRepository clientRepository;
    private final CdCatalogClient cdCatalogClient;
    private final ApplicationEventPublisher applicationEventPublisher;

    public RentCatalog(RentRepository rentRepository, RentService rentService, ApplicationEventPublisher applicationEventPublisher, ClientRepository clientRepository, CdCatalogClient cdCatalogClient) {
        this.rentRepository = rentRepository;
        this.rentService = rentService;
        this.cdCatalogClient = cdCatalogClient;
        this.clientRepository = clientRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @NonNull
    public Optional<Rent> findById(@NonNull RentId rentId) {
        Objects.requireNonNull(rentId, "rentId must not be null");
        return rentRepository.findById(rentId);
    }

    @NonNull
    public List<Rent> findAll() {
        return rentRepository.findAll();
    }

    public RentId createRent(String clientId, String cdId) {
        Objects.requireNonNull(clientId,"clientId must not be null");
        Objects.requireNonNull(cdId,"cdId must not be null");

        if(!rentService.canRent(new ClientId(clientId))){
            throw new IllegalArgumentException("You have rented a cd and haven't returned it!");
        }

        Rent rent = new Rent(clientRepository.findById(new ClientId(clientId)).orElseThrow(ClientNotFoundException::new));
        rent.addItem(cdCatalogClient.findById(new CdId(cdId)));

        var newRent = rentRepository.saveAndFlush(rent);
        applicationEventPublisher.publishEvent(new RentCreated(newRent.id(), Instant.now()));
        RentItem rentItem = newRent.getItem();
        applicationEventPublisher.publishEvent(new RentItemAdded(newRent.id(),rentItem.id(),rentItem.getCdId(), Instant.now()));

        return newRent.id();
    }
}
