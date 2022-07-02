package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserAccountRepository {

    UserAccount save(UserAccount user);

    Optional<UserAccount> findById(Long id);

    Optional<UserAccount> findByName(String name);

    List<UserAccount> findAll();
}