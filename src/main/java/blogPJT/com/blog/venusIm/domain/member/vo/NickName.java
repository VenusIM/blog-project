package blogPJT.com.blog.venusIm.domain.member.entity.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class NickName {

    @NotBlank(message = "닉네임은 필수 항목입니다.")
    @Column(name = "nick_name", nullable = false)
    private String nickName;
}
