package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.domain.UserFocus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface UserFocusRepository extends JpaRepository<UserFocus, Long> {

    ArrayList<UserFocus> findByUserno(Long userno);

    UserFocus findByUsernoAndFocusdate(Long userno, String focusdate);

    ArrayList<UserFocus> findByUsernoAndFocusdateLike(Long userno, String focusdate);

}
