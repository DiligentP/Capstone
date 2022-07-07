package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.domain.UserFocus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFocusRepository extends JpaRepository<UserFocus, Long> {

    UserFocus findByUserno(Long userno);

}
