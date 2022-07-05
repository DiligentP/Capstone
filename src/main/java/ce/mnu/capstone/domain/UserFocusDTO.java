package ce.mnu.capstone.domain;

import lombok.Data;

@Data
public class UserFocusDTO {
    
    // 유저 번호
    private Long userno;
    // 집중시간
    private Long focustime;
    // 비집중시간
    private Long unfocustime;
    // 집중도
    private double con_per;
}
