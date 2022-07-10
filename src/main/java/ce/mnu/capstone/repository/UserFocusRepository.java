package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.domain.UserFocus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface UserFocusRepository extends JpaRepository<UserFocus, Long> {

    UserFocus findByUserno(Long userno);

    UserFocus findByUsernoAndFocusdate(Long userno, String focusdate);

    ArrayList<UserFocus> findByUsernoAndFocusdateLike(Long userno, String focusdate);

    @Query("SELECT u FROM UserFocus u WHERE u.userno=:userno and u.focusdate like :focusdate%")
    ArrayList<UserFocus> findByFocusdate(Long userno, String focusdate);
}
