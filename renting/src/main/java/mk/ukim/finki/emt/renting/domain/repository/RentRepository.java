package mk.ukim.finki.emt.renting.domain.repository;

import mk.ukim.finki.emt.renting.domain.model.Rent;
import mk.ukim.finki.emt.renting.domain.model.RentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentRepository extends JpaRepository<Rent, RentId> {
}
