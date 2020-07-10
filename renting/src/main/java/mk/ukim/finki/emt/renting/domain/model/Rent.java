package mk.ukim.finki.emt.renting.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;

@Entity
@Getter
@Table(name = "rent")
public class Rent extends AbstractEntity<RentId> {

    @Version
    private Long version;

    private LocalDate rentedOn;

    private LocalDate returnOn;

    @Column(name = "rent_state", nullable = false)
    @Enumerated(EnumType.STRING)
    private RentState state;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private RentItem item;

    @ManyToOne
    private Client client;

    private Rent() {}

    public Rent(@NonNull Client client) {
        super(DomainObjectId.randomId(RentId.class));
        this.rentedOn = LocalDate.now();
        this.returnOn = LocalDate.now().plusDays(10);
        this.state = RentState.RENTED;
        this.client = client;
    }

    public Rent(@NonNull LocalDate rentedOn, @NonNull LocalDate returnOn, @NonNull RentState state, @NonNull Client client) {
        super(DomainObjectId.randomId(RentId.class));
        this.rentedOn = rentedOn;
        this.returnOn = returnOn;
        this.state = state;
        this.client = client;
    }

    public Money total() {
        if(LocalDate.now().isAfter(returnOn)){
            return item.getItemPrice().add(new Money(Currency.MKD, 100));
        }
        return item.getItemPrice();
    }

    public RentItem addItem(Cd cd) {
        Objects.requireNonNull(cd, "Cd must not be null");
        if(!cd.getIsAvailable()){
            throw new IllegalArgumentException("Cd must be available!");
        }
        var item = new RentItem(cd.getId(), cd.getPrice(), cd.getIsAvailable());
        this.item = item;
        return item;
    }

    public void setState(RentState state) {
        this.state = state;
    }
}