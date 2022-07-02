package ce.mnu.capstone.controller;

import ce.mnu.capstone.domain.TestVO;
import ce.mnu.capstone.domain.UserAccount;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                .userphone("010-1234-4567")
                .useremail("woongs@gmail.com")
                .userage(27L)
                .build();

        if (id.equals("woong") && pass.equals("woong")){
            return user;
        }
        else{
            return null;
        }

    }
}
