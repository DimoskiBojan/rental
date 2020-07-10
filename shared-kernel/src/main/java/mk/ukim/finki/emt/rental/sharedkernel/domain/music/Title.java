package mk.ukim.finki.emt.rental.sharedkernel.domain.music;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import mk.ukim.finki.emt.rental.sharedkernel.domain.base.ValueObject;
import org.springframework.lang.NonNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
public class Title implements ValueObject {

    @Column(name="title")
    private final String title;

    //unused
    private Title() {this.title="";}

    @JsonCreator
    public Title(@NonNull String title) {
        this.title = Objects.requireNonNull(title, "title must not be null");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Title title1 = (Title) o;
        return Objects.equals(title, title1.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title);
    }

    @Override
    @JsonValue
    public String toString() {
        return title;
    }
}
