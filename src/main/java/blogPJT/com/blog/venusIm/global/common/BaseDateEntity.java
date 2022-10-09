package blogPJT.com.blog.venusIm.global.common;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass // 부모 클래스(엔티티)에 필드를 선언하고 단순히 속성만 받아서 사용
@EntityListeners(AuditingEntityListener.class) // 엔티티를 DB에 적용하기 전, 이후에 커스텀 콜백을 요청
public class BaseDateEntity {

    @CreatedDate
    @Column(name = "create_date", updatable = false)
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @Column(name = "delete_date")
    private LocalDateTime deleteDate;

    public void deleteDate() {
        this.deleteDate = LocalDateTime.now();
    }

}
