package mk.ukim.finki.emt.renting.application;

import mk.ukim.finki.emt.renting.domain.model.Cd;
import mk.ukim.finki.emt.renting.domain.model.CdId;

import java.util.List;

public interface CdCatalog {

    List<Cd> findAll();

    Cd findById(CdId id);
}
