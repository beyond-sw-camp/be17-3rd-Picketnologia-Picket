package com.picketlogia.picket.api.auth.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthCodeMailService {

    private final JavaMailSender mailSender;
    private final AuthCodeCreator authCodeCreator;
    private final StringRedisTemplate redisTemplate;

    private static final boolean IS_HTML = true;
    private static final String SUBJECT = "[Picket] 안녕하세요. 요청하신 인증번호를 보내드립니다.";
    private static final String DEFAULT_ENCODE = "UTF-8";

    public void sendToEmail(String email) {
        MimeMessage mimeMessage = createMimeMessage(email);
        mailSender.send(mimeMessage);
    }

    /**
     * MimeMessage 생성
     * @param email 인증 코드를 전송하기 위한 이메일
     * @return MimeMessage
     */
    private MimeMessage createMimeMessage(String email) {
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        String createAuthCode = getAuthCode();

        try {

            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, DEFAULT_ENCODE);
            messageHelper.setTo(email);
            messageHelper.setSubject(SUBJECT);
            messageHelper.setText(createAuthCodeView(createAuthCode), IS_HTML);

            redisTemplate.opsForValue().set(email, createAuthCode, Duration.ofMinutes(10));


        } catch (MessagingException e) {
            log.error(e.getMessage(), e);
        }

        return mimeMessage;

    }

    /**
     * 이메일에 보여주기 위한 내용 추가
     * @return String 형식의 html
     */
    private String createAuthCodeView(String authCode) {
        String rawView = """
                <html>
                    <head>
                    </head>
                <body>
                    <p>
                        안녕하세요.<br>
                        저희 <b>Picket</b>을 이용해 주셔서 감사합니다.<br>
                        요청하신 인증 번호를 보내드립니다.
                    </p>
                <strong style="font-size:40px">
                    %s
                </strong>
                    <p>
                        위의 인증번호 6자리를 인증번호 입력창에 입력해주세요.<br>
                        <font size=1><b>개인정보 보호를 위해서 인증번호는 5분간 유지됩니다.</b></font>
                    </p>
                </body>
                </html>
               """;

        return String.format(rawView, authCode);
    }

    private String getAuthCode() {
        return authCodeCreator.generateAuthCode();
    }
}
