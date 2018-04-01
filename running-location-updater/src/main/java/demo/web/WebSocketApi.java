package demo.web;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketApi {

    @MessageMapping("/sendMessage")
    @SendTo("/queue/locations")
    public String sendMessage(String message) throws Exception {
        return message;
    }
}
