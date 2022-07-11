package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserFocus;
import ce.mnu.capstone.repository.UserFocusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserFocusServiceImpl implements UserFocusService{

    UserFocusRepository userFocusRepository;

    @Autowired
    public UserFocusServiceImpl(UserFocusRepository userFocusRepository) {
        this.userFocusRepository = userFocusRepository;
    }

    /**
     * 유저 집중시간 업데이트
     * @param userFocus
     */
    @Override
    public UserFocus modifyUserFocus(UserFocus userFocus) {

        return userFocusRepository.save(userFocus);
    }

    /**
     * 유저 집중시간 요청
     * @param userno
     */
    @Override
    public ArrayList<UserFocus> getUserFocus(Long userno) {

        return userFocusRepository.findByUserno(userno);
    }

    /**
     * 유저 일별 집중시간 요청
     * @param userno
     * @param all_date (yyyy-mm-dd)
     */
    @Override
    public UserFocus getUserFocusAndDate(Long userno, String all_date) {

        return userFocusRepository.findByUsernoAndFocusdate(userno,all_date);
    }

    /**
     * 유저 월별 집중시간 요청
     * @param userno
     * @param ym_date (yyyy-mm)
     */
    @Override
    public ArrayList<UserFocus> getUserFocusStanMonth(Long userno, String ym_date) {
        return userFocusRepository.findByUsernoAndFocusdateLike(userno,ym_date);
    }

    /**
     * 유저 랭킹 요청
     */
    @Override
    public ArrayList<UserFocus> getRank() {
//        return userFocusRepository.findAll(Sort.by(Sort.Direction.DESC, "focustime"));
        return userFocusRepository.findDiligent();
    }

    /**
     * 유저의 누적 집중시간 집계
     */
    @Override
    public Long getUserTotalTime(Long userno) {
        return userFocusRepository.findUserTotalTime(userno);
    }
}
