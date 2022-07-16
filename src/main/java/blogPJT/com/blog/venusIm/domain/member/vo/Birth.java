package blogPJT.com.blog.venusIm.domain.member.entity.vo;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
public class Birth {

    @NotBlank(message = "생년월일은 필수 항목 입니다.")
    @Column(nullable = false)
    private String birth;

    private String year;
    private String month;
    private String day;
}
