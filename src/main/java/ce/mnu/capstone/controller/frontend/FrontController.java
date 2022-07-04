package ce.mnu.capstone.controller.frontend;

import ce.mnu.capstone.domain.UserAccount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"클라이언트에 제공하는 API"})
public class FrontController {

    @GetMapping("/login")
    @ApiOperation(value = "유저 로그인", notes = "")
    public ResponseEntity<UserAccount> testWoong(@RequestParam("id") String id, @RequestParam("pass") String pass) {
        UserAccount user = UserAccount.builder()
                .userid("woong")
                .userpass("woong")
                .username("박건웅")
                .build();

        if (id.equals("woong") && pass.equals("woong")){
            return ResponseEntity.ok().body(user);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/reg")
    public String testReg(@RequestParam("userid") String id, @RequestParam("userpass") String pass, @RequestParam("username") String name){
        UserAccount user = UserAccount.builder()
                .userid(id)
                .userpass(pass)
                .username(name)
                .build();
        System.out.println("Reg Data : " + id + pass + name);

        return "{\"status\":\"success\"}";
    }
}
