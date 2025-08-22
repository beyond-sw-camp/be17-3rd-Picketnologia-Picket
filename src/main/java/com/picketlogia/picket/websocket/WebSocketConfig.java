
package com.picketlogia.picket.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

// 기본적으로 클라이언트와 스프링 서버가 HTTP 통신
//      한 번 요청하고 한 번 응답하면 끝
//      연결이 끊기면 다시 데이터를 주고받기 위해서 다시 연결 필요
//      연결이 된 상태에서도 클라이언트가 무조건 먼저 데이터 통신

// 웹 소켓
//      실시간성이 필요한 기능을 구현하기에 적합, 다른 사람이 서버랑 작업하는 내용이 내 화면에 바로 나올 때
//      HTTP로 먼저 통신(웹 소켓으로 통신 업그레이드 요청)
//      양방향 통신


// 메시지 브로커
//      일반적인 웹소켓으로 특정 채팅방에 있는 사용자들에게만 메시지를 보내는 기능을 구현하기 귀찮음
//      구독한 사람에게만 메시지를 보내는 기능을 제공
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").setAllowedOrigins("*");
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/product"); // 예매자가 메시지를 받을 경로
        registry.setApplicationDestinationPrefixes("/order"); // 서버가 메시지를 받을 경로
    }
}
