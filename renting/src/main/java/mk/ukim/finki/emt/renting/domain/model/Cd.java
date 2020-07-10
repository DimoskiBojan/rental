package mk.ukim.finki.emt.renting.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.rental.sharedkernel.domain.music.Title;

@Getter
public class Cd {

    private CdId id;

    private Title title;

    private Money price;

    private Boolean isAvailable;
}