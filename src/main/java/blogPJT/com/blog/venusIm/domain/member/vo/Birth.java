package blogPJT.com.blog.venusIm.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Birth {

    @NotBlank(message = "필수 값입니다 : Birth")
    @Column(nullable = false)
    private String birth;

    private String year;
    private String month;
    private String day;

    public Birth(final String year, final String month, final String day) {
        this.birth = year + "-" + month + "-" + day;
    }

    public static Birth from(final String year, final String month, final String day) {
        return new Birth(year, month, day);
    }

    @JsonValue
    public String birth() {
        return birth;
    }

    @Override
    public int hashCode() {
        return Objects.hash(birth());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Birth birth = (Birth) obj;

        return Objects.equals(birth(), birth.birth());
    }
}
