package ce.mnu.capstone;

import ce.mnu.capstone.domain.UserFocus;
import ce.mnu.capstone.domain.UserRankDTO;
import ce.mnu.capstone.repository.UserFocusRepository;
import ce.mnu.capstone.service.UserFocusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
@Slf4j
class CapstoneApplicationTests {

    @Autowired
    UserFocusService userFocusService;

    @Test
    public void Test(){
        UserFocus user = userFocusService.getUserFocusAndDate(1L, "2022-00-01");

        if(user==null){
            log.info("user null");
        }
        else{
            log.info("user not null");
        }


    }
}
