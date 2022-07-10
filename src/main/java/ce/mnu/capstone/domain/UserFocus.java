package ce.mnu.capstone.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter @NoArgsConstructor
@Table(name = "user_focus")
public class UserFocus {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(name = "집중 인덱스")
    private Long focusno;
    @ApiModelProperty(name = "유저 번호")
    private Long userno;
    @ApiModelProperty(name = "집중 시간")
    private Long focustime;
    @ApiModelProperty(name = "비집중 시간")
    private Long unfocustime;
    @ApiModelProperty(name = "집중 퍼센트")
    private float con_per;

    @ApiModelProperty(name = "집중 날짜")
    private String focusdate;

    @Builder
    public UserFocus(Long userno, Long focustime, Long unfocustime, float con_per) {
        this.userno = userno;
        this.focustime = focustime;
        this.unfocustime = unfocustime;
        this.con_per = con_per;
    }
}