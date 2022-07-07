package ce.mnu.capstone.controller.deeplearning;

import ce.mnu.capstone.domain.UserFocus;
import ce.mnu.capstone.service.UserFocusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController @Slf4j
@Api(tags = {"딥러닝서버에 제공하는 API"})
public class DeepController {

    UserFocusService userFocusService;

    @Autowired
    public DeepController(UserFocusService userFocusService) {
        this.userFocusService = userFocusService;
    }

    @PostMapping("/deep")
    @ApiOperation(value = "유저 집중시간 요청 테스트 API", notes = "파라미터 Json")
    public String deepJsonTest(@RequestBody HashMap<String, Object> json){
        log.info("json : " + json);

        return "success";
    }

    @GetMapping("/getUserFocus")
    @ApiOperation(value = "유저 집중시간 조회 요청 API", notes = "파라미터 userno")
    public ResponseEntity<UserFocus> getUserFocus(@RequestParam Long userno){
        log.info("딥러닝서버 유저 집중시간 조회 요청 :  UserNo : {}", userno);

        UserFocus Response = userFocusService.getUserFocus(userno);

        if(Response == null) {
            log.warn("딥러닝 서버 요청 실패 : {}","존재하지 않는 유저");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("딥러닝 서버 요청 성공 : {}", Response);
        return ResponseEntity.ok().body(Response);
    }


    @PutMapping("/updateUserFocus")
    @ApiOperation(value = "유저 집중시간 갱신 요청 API", notes = "파라미터 Json")
    public Boolean modifyUserFocus(@RequestBody UserFocus json){
        log.info("딥러닝서버 유저 집중시간 갱신 요청 :  {}", json);

        UserFocus user = userFocusService.modifyUserFocus(json);

        log.info("딥러닝 서버 요청 성공 : {}", user);
        return true;
    }


}
