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

    // /product/event/{roomId} 경로로 메세지 전달 시 sendMessage 메서드 실행
    @MessageMapping("/event/{roomId}/{day}/{round}")
    public void sendMessage(@DestinationVariable String roomId, @DestinationVariable String day, @DestinationVariable String round, String message) {
        System.out.println("Send Message: " + message);
        messagingTemplate.convertAndSend("/product/" + roomId + "/" + day + "/" + round, message);
    }
}