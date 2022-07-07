package ce.mnu.capstone.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter @NoArgsConstructor
@Table(name = "user_focus")
public class UserFocus {

    @Id
    private Long userno;
    private Long focustime;
    private Long unfocustime;
    private float con_per;

    @Builder
    public UserFocus(Long userno, Long focustime, Long unfocustime, float con_per) {
        this.userno = userno;
        this.focustime = focustime;
        this.unfocustime = unfocustime;
        this.con_per = con_per;
    }
}