package ce.mnu.capstone.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter @NoArgsConstructor
@Table(name = "user_focus")
@IdClass(UserFocus.UserFocusKey.class)
public class UserFocus {
    @Id
    @ApiModelProperty(name = "유저 번호")
    private Long userno;
    @Id
    @ApiModelProperty(name = "집중 날짜")
    private String focusdate;
    @ApiModelProperty(name = "집중 시간")
    private Long focustime;
    @ApiModelProperty(name = "비집중 시간")
    private Long unfocustime;
    @ApiModelProperty(name = "집중 퍼센트")
    private float con_per;

    @EqualsAndHashCode
    @Embeddable
    static class UserFocusKey implements Serializable{

        @Column
        private Long userno;

        @Column
        private String focusdate;
    }


    @Builder
    public UserFocus(Long userno, Long focustime, Long unfocustime, float con_per) {
        this.userno = userno;
        this.focustime = focustime;
        this.unfocustime = unfocustime;
        this.con_per = con_per;
    }
}