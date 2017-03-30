package anamnesis_morbi.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by dmitriigavrylov on 17.03.17.
 */
@Controller
public class HelloController {
    @RequestMapping(value = "/index.jsp",method = RequestMethod.GET)
    public String test(@RequestParam("name") String param, Model model) {
        model.addAttribute("name", param);
        return "hello";
    }
}
