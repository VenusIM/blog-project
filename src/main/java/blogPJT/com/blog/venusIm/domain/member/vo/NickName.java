package blogPJT.com.blog.venusIm.domain.member.vo;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class NickName {

    @NotBlank(message = "필수 값입니다 : nickName")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "영어만 입력이 가능합니다 : nickName")
    @Column(name = "NICK_NAME", nullable = false)
    @Length(max = 15)
    private String nickName;

    public static NickName from(final String nickName) {
        return new NickName(nickName);
    }

    @JsonValue
    public String nickName() {
        return nickName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickName());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        NickName nickName = (NickName) obj;

        return Objects.equals(nickName(), nickName.nickName());
    }


}
