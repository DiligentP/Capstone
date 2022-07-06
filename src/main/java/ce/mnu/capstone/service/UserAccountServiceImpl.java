package ce.mnu.capstone.service;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserAccountServiceImpl implements UserAccountService{

    UserAccountRepository userAccountRepository;

    @Autowired
    public UserAccountServiceImpl(UserAccountRepository userAccountRepository) {
        this.userAccountRepository = userAccountRepository;
    }


    /**
     *  유저 계정정보 조회 (userno)
     * @return UserAccount
     */
    @Override
    public UserAccount getUser(Long userno) {
        return userAccountRepository.findByUserno(userno);
    }

    /**
     *  유저 계정정보 저장 (UserAccount)
     * @return UserAccount
     */
    @Override
    public UserAccount Register(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    /**
     *  유저 로그인 확인
     * @return UserAccount
     */
    @Override
    public UserAccount Login(String id, String pass) {
        return userAccountRepository.findByUseridAndUserpass(id, pass);
    }

    /**
     *  회원 탈퇴
     */
    @Override
    public void Deregister(Long userno) {
        UserAccount user = userAccountRepository.findByUserno(userno);
        userAccountRepository.delete(user);
    }
}
