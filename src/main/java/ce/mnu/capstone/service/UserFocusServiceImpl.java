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

    @Override
    public UserFocus modifyUserFocus(UserFocus userFocus) {

        return userFocusRepository.save(userFocus);
    }

    @Override
    public UserFocus getUserFocus(Long userno) {
        return userFocusRepository.findByUserno(userno);
    }
}
