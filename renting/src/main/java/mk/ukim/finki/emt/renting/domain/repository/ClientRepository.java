package mk.ukim.finki.emt.renting.domain.repository;

import mk.ukim.finki.emt.renting.domain.model.Client;
import mk.ukim.finki.emt.renting.domain.model.ClientId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, ClientId> {
}
