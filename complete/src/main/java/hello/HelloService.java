package hello;


import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
	
	final static Logger logger = LoggerFactory.getLogger(HelloService.class);
	
	@Autowired
	private SimpMessagingTemplate template;
	
	public void service(HelloMessage message, Principal principal) {
		String text = "{\"content\":\"Hello, "+message.getName()+ " -- "+ principal.getName()+" fromm Q\"}";
		this.template.convertAndSendToUser(principal.getName(), "/queue/greetings", text);
		//this.template.convertAndSend("/queue/greetings", text);
	}

}
