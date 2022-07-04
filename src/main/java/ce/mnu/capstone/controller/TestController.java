package ce.mnu.capstone.controller;

import ce.mnu.capstone.domain.TestVO;
import ce.mnu.capstone.domain.UserAccount;
import ce.mnu.capstone.domain.UserFocus;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class TestController {
    @RequestMapping("/")
    public String index () {
        return "Hello World";
    }

    @RequestMapping("/test")
    public TestVO test() {
        TestVO test = new TestVO();

        String name = "박건웅";
        String phone = "010-1234-5678";
        test.setName(name);
        test.setPhone(phone);

        return test;
    }
    @RequestMapping("/login")
    public UserAccount testWoong(@RequestParam("id") String id, @RequestParam("pass") String pass) {
        UserAccount user = UserAccount.builder()
                .userid("woong")
                .userpass("woong")
                .username("박건웅")
                .build();

        if (id.equals("woong") && pass.equals("woong")){
            return user;
        }
        else{
            return null;
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

        return "success";
    }

    @PostMapping("/deep")
    public String deepJson(@RequestBody HashMap<String, Object> json){
        System.out.println("json : " + json);

        return "success";
    }
}
