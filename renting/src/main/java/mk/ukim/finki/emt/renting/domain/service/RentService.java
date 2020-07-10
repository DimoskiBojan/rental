package mk.ukim.finki.emt.renting.domain.service;

import mk.ukim.finki.emt.renting.domain.exceptions.RentNotFoundException;
import mk.ukim.finki.emt.renting.domain.model.ClientId;
import mk.ukim.finki.emt.renting.domain.model.Rent;
import mk.ukim.finki.emt.renting.domain.model.RentId;
import mk.ukim.finki.emt.renting.domain.model.RentState;
import mk.ukim.finki.emt.renting.domain.repository.ClientRepository;
import mk.ukim.finki.emt.renting.domain.repository.RentRepository;
import mk.ukim.finki.emt.renting.port.client.CdCatalogClient;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Transactional
public class RentService {
    private final RentRepository rentRepository;

    public RentService(RentRepository rentRepository) {
        this.rentRepository = rentRepository;
    }

    public Boolean canRent(ClientId clientId) {
        List<Rent> rents = rentRepository.findAll();
        AtomicReference<Boolean> canRent = new AtomicReference<>();
        canRent.set(true);

        rents.forEach(rent -> {
            ClientId rentClientId = rent.getClient().getId();
            if(rentClientId.getId().equals(clientId.getId()) && rent.getState().equals(RentState.RENTED)){
                canRent.set(false);
            }
        });

        return canRent.get();
    }

    public Boolean canReturnRent(RentId rentId) {
        Rent rent = rentRepository.findById(rentId).orElseThrow(RentNotFoundException::new);

        return rent.getState().equals(RentState.RENTED);
    }
}
