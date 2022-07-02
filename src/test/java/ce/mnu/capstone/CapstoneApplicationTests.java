package ce.mnu.capstone;

import ce.mnu.capstone.domain.UserAccount;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ce.mnu.capstone.repository.UserAccountRepository;
import org.springframework.test.annotation.Commit;

import javax.transaction.Transactional;
import java.util.Date;

@SpringBootTest
@Transactional
class CapstoneApplicationTests {

    @Autowired
    UserAccountRepository userAccountRepository;

    @Test
    void 회원가입() {
        UserAccount user = UserAccount.builder()
                .userid("park")
                .userpass("park")
                .username("박정현")
                .userphone("010-8846-4832")
                .useremail("qkrwjdgus0603@gmail.com")
                .userage(25L)
                .build();

        userAccountRepository.save(user);
    }
}
