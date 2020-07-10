package mk.ukim.finki.emt.renting;

import mk.ukim.finki.emt.rental.sharedkernel.domain.bio.*;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.Address;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.CityName;
import mk.ukim.finki.emt.rental.sharedkernel.domain.geo.Country;
import mk.ukim.finki.emt.renting.domain.model.Client;
import mk.ukim.finki.emt.renting.domain.model.ClientId;
import mk.ukim.finki.emt.renting.domain.repository.ClientRepository;
import mk.ukim.finki.emt.renting.domain.repository.RentRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Component
public class DataGenerator {
    private final RentRepository rentRepository;
    private final ClientRepository clientRepository;

    public DataGenerator(RentRepository rentRepository, ClientRepository clientRepository) {
        this.rentRepository = rentRepository;
        this.clientRepository = clientRepository;
    }

    @PostConstruct
    @Transactional
    public void generateData() {
        if (clientRepository.findAll().size()==0) {
            Client client = new Client(new ClientId("1"),
                    new FullName("Bojan", "Dimoski"),
                    new Address("Wall Street",
                            new CityName("New York"), Country.USA),
                    new Email("dimoskib@example.com"),
                    new PhoneNumber("+38975223305"));
            clientRepository.save(client);
        }
    }
}
