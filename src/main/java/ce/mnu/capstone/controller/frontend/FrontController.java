package ce.mnu.capstone.controller.frontend;

import ce.mnu.capstone.domain.UserAccountDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"클라이언트에 제공하는 API"})
public class FrontController {

    @GetMapping("/login")
    @ApiOperation(value = "유저 로그인", notes = "아이디와 패스워드를 파라미터 값으로 넘겨주시면 됩니다. 성공 200  실패 404")
    public ResponseEntity<UserAccountDTO> testWoong(@RequestParam("id") String id, @RequestParam("pass") String pass) {
        UserAccountDTO user = UserAccountDTO.builder()
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
    @ApiOperation(value = "유저 회원가입", notes = "파라미터 userid, userpass, username")
    public String testReg(@RequestParam("userid") String id, @RequestParam("userpass") String pass, @RequestParam("username") String name){
        UserAccountDTO user = UserAccountDTO.builder()
                .userid(id)
                .userpass(pass)
                .username(name)
                .build();
        System.out.println("Reg Data : " + id + pass + name);

        return "{\"status\":\"success\"}";
    }
}
