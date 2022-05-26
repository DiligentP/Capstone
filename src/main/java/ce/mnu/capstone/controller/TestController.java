package ce.mnu.capstone.controller;

import ce.mnu.capstone.VO.TestVO;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
