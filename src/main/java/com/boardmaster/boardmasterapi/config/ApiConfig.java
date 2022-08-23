package com.boardmaster.boardmasterapi.config;

import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiConfig {
    private final String DOMAIN = "https://api.coolsms.co.kr";
    private final String API_KEY = "NCSKAFURJDXE1A7E";
    private final String SECRET_API_KEY = "WS5HIY8JSPYCLLX0SCX3Y3JY21WKWYRF";

    private DefaultMessageService messageService;

    /**
     * <a href="https://docs.coolsms.co.kr/development-kits/java">message api 참고</a>
     * <p>하루 50건 무료</p>
     */
    @Bean
    public DefaultMessageService messageService() {
        this.messageService = NurigoApp.INSTANCE.initialize(API_KEY, SECRET_API_KEY, DOMAIN);

        return messageService;
    }
}
