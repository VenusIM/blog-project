package blogPJT.com.blog.venusIm.domain.member.entity.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Password {

    @NotBlank(message = "비밀번호는 필수 항목입니다.")
    @Column(nullable = false)
    private String password;
}
