package com.picketlogia.picket.websocket;

import com.picketlogia.picket.api.seat.service.SeatStatusService;
import com.picketlogia.picket.websocket.model.SeatSelectionMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequiredArgsConstructor
public class WebSocketController {

    private final SimpMessagingTemplate messagingTemplate;
    // 실시간 좌석 상태 처리를 위한 서비스 의존성 주입
    private final SeatStatusService seatStatusService;

    /*  --- 강사님 코드 ---
    @MessageMapping("/abc")     // 클라이언트가 웹 소켓으로 /order/abc로 메시지를 보내면 메소드 실행
    @SendTo("/product/abc")       // /product/abc를 구독한 클라이언트들에게만 메시지 전송
    public String abc() {

        return "zzzzzz";
    }

    // /product/event/{roomId}/{day}/{round} 경로로 메세지 전달 시 sendMessage 메서드 실행
    @MessageMapping("/event/{roomId}/{day}/{round}")
    public void sendMessage(@DestinationVariable String roomId, @DestinationVariable String day, @DestinationVariable String round, String message) {
        System.out.println("Send Message: " + message);
        messagingTemplate.convertAndSend("/product/" + roomId + "/" + day + "/" + round, message);
    }
    */
    // 서버가 메세지 받는 주소(Send)
    //order/seats/${eventIdx}/{select}
    @MessageMapping("/seats/{roundId}/{datetime}/select")
    public void selectSeat(@DestinationVariable Long roundId, @DestinationVariable String datetime, SeatSelectionMessage message) {
        // 1. Redis에 좌석 상태 업데이트
        seatStatusService.updateSeatStatus(roundId, datetime, message.getSeatName(), message.getAction());

        // 2. 토픽을 구독하는 클라이언트들에게 변경된 좌석 정보 전달
        // 클라이언트는 /topic/seats/{roundId}를 구독해야함ㅇㅇ
        // 보내는 주소(subscribe(/topic/seats/${eventIdx})
        messagingTemplate.convertAndSend("/topic/seats/" + roundId + "/" + datetime, message);
    }
}