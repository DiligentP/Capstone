package ce.mnu.capstone.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_focus")
public class UserFocus {

    @Id
    private Long userno;
    private Long focustime;
    private Long unfocustime;
    private double con_per;

}