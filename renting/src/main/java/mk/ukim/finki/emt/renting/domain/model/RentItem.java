package mk.ukim.finki.emt.renting.domain.model;

import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.DomainObjectId;
import mk.ukim.finki.emt.rental.sharedkernel.domain.financial.Money;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "rent_item")
public class RentItem extends AbstractEntity<RentItemId> {

    @Embedded
    @AttributeOverride(name="id",column = @Column(name="cd_id",nullable = false))
    private CdId cdId;

    @Version
    private Long version;

    @Embedded
    private Money itemPrice;

    private Boolean isAvailable;

    private RentItem() {
    }

    public RentItem(@NonNull CdId cdId, @NonNull Money itemPrice, @NonNull Boolean isAvailable) {
        super(DomainObjectId.randomId(RentItemId.class));
        this.cdId = cdId;
        this.itemPrice = itemPrice;
        this.isAvailable = isAvailable;
    }

    public void setCdId(CdId cdId) {
        this.cdId = cdId;
    }

    public void setItemPrice(Money itemPrice) {
        this.itemPrice = itemPrice;
    }

    public void setAvailable(Boolean available) {
        isAvailable = available;
    }
}