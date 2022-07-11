package ce.mnu.capstone.repository;

import ce.mnu.capstone.domain.UserFocus;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;

public interface UserFocusRepository extends JpaRepository<UserFocus, Long> {

    ArrayList<UserFocus> findByUserno(Long userno);

    UserFocus findByUsernoAndFocusdate(Long userno, String focusdate);

    ArrayList<UserFocus> findByUsernoAndFocusdateLike(Long userno, String focusdate);

    ArrayList<UserFocus> findAll(Sort sort);

    @Query(value = "SELECT *,SUM(focustime)AS totalTime FROM user_focus GROUP BY userno ORDER BY totalTime DESC", nativeQuery = true)
    ArrayList<UserFocus> findDiligent();

    @Query(value = "SELECT SUM(focustime) FROM user_focus WHERE userno = :userno", nativeQuery = true)
    Long findUserTotalTime(Long userno);

}
