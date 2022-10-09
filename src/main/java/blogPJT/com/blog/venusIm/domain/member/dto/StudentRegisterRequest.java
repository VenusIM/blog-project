package blogPJT.com.blog.venusIm.domain.member.dto;

import blogPJT.com.blog.venusIm.domain.member.persist.Member;
import blogPJT.com.blog.venusIm.domain.member.vo.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StudentRegisterRequest {

    @Valid
    @NotNull(message = "필수 값입니다 : Email")
    private Email email;

    @Valid
    @NotNull(message = "필수 값입니다 : Password")
    private Password password;

    @Valid
    @NotNull(message = "필수 값입니다 : NickName")
    private NickName nickName;

    @NotNull(message = "필수 값입니다 : Birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-mm-dd")
    private LocalDate birth;

    public Member toEntity() {
        return Member.builder()
                .email(email)
                .password(password)
                .nickName(nickName)
                .birth(birth)
                .roleType(RoleType.STUDENT)
                .build();
    }
}
