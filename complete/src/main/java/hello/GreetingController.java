package hello;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	
	@Autowired
	private HelloService helloService;

    @MessageMapping("/hello")
    public void greeting(HelloMessage message, Principal principal) throws Exception {
        Thread.sleep(1000); // simulated delay
        helloService.service(message, principal);
    }

}
