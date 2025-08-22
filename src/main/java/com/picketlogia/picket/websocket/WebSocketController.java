package com.picketlogia.picket.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/abc")     // 클라이언트가 웹 소켓으로 /order/abc로 메시지를 보내면 메소드 실행
    @SendTo("/product/abc")       // /product/abc를 구독한 클라이언트들에게만 메시지 전송
    public String abc() {

        return "zzzzzz";
    }
    @MessageMapping("/event/{roomId}")
    public void sendMessage(@DestinationVariable String roomId, String message) {
        System.out.println("Send Message: " + message);
        messagingTemplate.convertAndSend("/product/" + roomId, message);
    }
}
