package ce.mnu.capstone.controller.deeplearning;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@Api(tags = {"딥러닝서버에 제공하는 API"})
public class DeepController {

    @PostMapping("/deep")
    public String deepJsonTest(@RequestBody HashMap<String, Object> json){
        System.out.println("json : " + json);

        return "success";
    }
}
