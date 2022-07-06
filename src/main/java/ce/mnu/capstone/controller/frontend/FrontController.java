package ce.mnu.capstone.controller.frontend;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.service.UserAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController @Slf4j
@Api(tags = {"클라이언트에 제공하는 API"})
public class FrontController {

    UserAccountService userAccountService;

    @Autowired
    public FrontController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @GetMapping("/login")
    @ApiOperation(value = "유저 로그인", notes = "파라미터 id, pass 성공 200  실패 400")
    public ResponseEntity<UserAccount> loginUser(@RequestParam("id") String id, @RequestParam("pass") String pass) {
        log.info("로그인 요청 : ID: {} PASS: {} ",id ,pass);

        UserAccount Response = userAccountService.Login(id,pass);

        if(Response == null) {
            log.warn("로그인 요청 실패 : {}","존재하지 않는 유저");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("로그인 요청 성공 : UserID : {} UserName : {}",Response.getUserid(),Response.getUsername());
        return ResponseEntity.ok().body(Response);
    }

    @PostMapping("/register")
    @ApiOperation(value = "유저 회원가입", notes = "파라미터 userid, userpass, username 성공 200  실패 400")
    public ResponseEntity<UserAccount> registerUser(@RequestParam("userid") String id, @RequestParam("userpass") String pass, @RequestParam("username") String name){

        log.info("유저 회원가입 요청 : ID : {} PASS : {} NAME : {}" ,id,pass,name);

        // User Bind
        UserAccount userAccount = UserAccount.builder().userid(id).userpass(pass).username(name).build();

        UserAccount Response = userAccountService.Register(userAccount);

        log.info("유저 회원가입 성공 : ID : {} PASS : {} NAME : {}",id,pass,name);
        return ResponseEntity.ok().body(Response);
    }


    @GetMapping("/get")
    @ApiOperation(value = "유저 정보 조회", notes = "파라미터 userno 성공 200 실패 400")
    public ResponseEntity getUserInfo(@RequestParam Long userno){

        log.info("유저 조회 요청 : UserNo : {}",userno);
        UserAccount Response = userAccountService.getUser(userno);

        if(Response == null) {
            log.warn("유저 조회 실패 : {}","존재하지 않는 유저");
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        log.info("유저 조회 성공 : UserID : {} UserName : {}",Response.getUserid(),Response.getUsername());
        return new ResponseEntity<>(Response, HttpStatus.OK);
    }

    @DeleteMapping("/deregister")
    @ApiOperation(value = "회원 탈퇴", notes = "파라미터 userno 성공 200 실패 400")
    public ResponseEntity deRegisterUser(@RequestParam Long userno) {
        log.info("회원 탈퇴 요청 : UserNo : {}",userno);

        userAccountService.Deregister(userno);

        log.info("회원 탈퇴 성공");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
