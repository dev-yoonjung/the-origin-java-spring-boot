package theorigin.javaspringboot.wschatting.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import theorigin.javaspringboot.wschatting.model.ChatMessage;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WebSocketMapping {
    private static final Logger logger = LoggerFactory.getLogger(WebSocketMapping.class);
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketMapping(@Autowired SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @MessageMapping("/ws/chat")
    public void sendChat(ChatMessage chatMessage) {
        logger.info(chatMessage.toString());
        final String time = new SimpleDateFormat("HH:mm").format(new Date());
        chatMessage.setTime(time);
        this.simpMessagingTemplate.convertAndSend(
                String.format("/receive-endpoint/%s", chatMessage.getRoomId()),
                chatMessage
        );
    }

//    @MessageMapping("/ws/chat")
//    @SendTo("/receive-endpoint/all")
//    public ChatMessage sendChatAll() {
//        return null;
//    }

}
