package ce.mnu.capstone.controller.frontend;

import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.domain.UserFocus;
import ce.mnu.capstone.domain.UserRankDTO;
import ce.mnu.capstone.repository.UserFocusRepository;
import ce.mnu.capstone.service.UserAccountService;
import ce.mnu.capstone.service.UserFocusService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController @Slf4j
@RequiredArgsConstructor
@Api(tags = {"클라이언트에 제공하는 API"})
public class FrontController {

    private final UserAccountService userAccountService;
    private final UserFocusService userFocusService;


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

    @GetMapping("/stats/day")
    @ApiOperation(value = "사용자 일별 집중 분석 통계 API", notes = "파라미터 userno, date(yyyy-mm-dd) 성공 200 실패 400")
    public ResponseEntity statsDay(@RequestParam Long userno, String date) {
        log.info("사용자 일별 집중 통계 요청 UserNo : {} Date : {}",userno,date);

        UserFocus Response = userFocusService.getUserFocusAndDate(userno,date);

        String Date = Response.getFocusdate();

        ArrayList<Object> arrayList = new ArrayList<>();
        arrayList.add(Response);

        HashMap<String, ArrayList<Object>> map = new HashMap<>();
        map.put(Date,arrayList);

        log.info("분석 정보 요청 성공 {}",map);
        return ResponseEntity.ok().body(map);
    }

    @GetMapping("/stats/month")
    @ApiOperation(value = "사용자 월별 집중 분석 통계 API", notes = "파라미터 userno, date(yyyy-mm) 성공 200 실패 400")
    public ResponseEntity statsMonth(@RequestParam Long userno, String date){
        log.info("사용자 월별 집중 통계 요청 UserNo : {} Date : {}",userno,date);

        ArrayList<UserFocus> Response = userFocusService.getUserFocusStanMonth(userno, date+"%");

        log.info("분석 정보 요청 성공 : {}",String.valueOf(Response) );
        return ResponseEntity.ok().body(Response);
    }

    @GetMapping("/rank")
    @ApiOperation(value = "사용자 랭킹 API", notes = "파라미터 () 성공 200 실패 400")
    public ResponseEntity rank() {
        log.info("사용자 랭킹 요청");
        ArrayList<UserFocus> R = userFocusService.getRank();
        ArrayList<Object> Rank = new ArrayList<>();

        for(int i=0; i<R.size(); i++){
            UserAccount user = userAccountService.getUser(R.get(i).getUserno());
            UserRankDTO dto = new UserRankDTO(
                    R.get(i).getUserno(),
                    user.getUserid(),
                    user.getUsername(),
                    userFocusService.getUserTotalTime(R.get(i).getUserno())
            );

           Rank.add(dto);
       }
        log.info("사용자 랭킹 요청 성공");
        return ResponseEntity.ok().body(Rank);
    }
}
