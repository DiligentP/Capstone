package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserFocus;
import ce.mnu.capstone.repository.UserFocusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public UserFocus getUserFocus(Long userno) {
        return userFocusRepository.findByUserno(userno);
    }

    /**
     * 유저 집중시간 요청 
     * @param userno
     * @param date
     */
    @Override
    public UserFocus getUSerFocusAndDate(Long userno, String date) {
        return userFocusRepository.findByUsernoAndFocusdate(userno,date);
    }
}
