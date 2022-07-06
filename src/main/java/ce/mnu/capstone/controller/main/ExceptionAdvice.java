package ce.mnu.capstone.controller.main;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

/**
 *  https://tecoble.techcourse.co.kr/post/2021-05-10-controller_advice_exception_handler/ 참고.
 */

@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    @ExceptionHandler(NullPointerException.class)
    public String nullPointerException(){
        return "NullPointerException";
    }

    @ExceptionHandler(SQLException.class)
    public String sqlException() { return "SQL Error";}
}
