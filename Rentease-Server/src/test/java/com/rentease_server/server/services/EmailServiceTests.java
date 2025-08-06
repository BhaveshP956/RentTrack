package com.rentease_server.server.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.javamail.JavaMailSender;

import com.rentease_server.server.dtos.requestdtos.EmailEnquiryDTO;

@SpringBootTest(properties = "spring.profiles.active=test")
public class EmailServiceTests {

    @Autowired
    private EmailService emailService;

    @MockBean
    private JavaMailSender javaMailSender;  // <-- Add this mock bean

    @Test
    void testSendMail() {
        EmailEnquiryDTO dto = EmailEnquiryDTO.builder()
                .name("Test User")
                .email("test@example.com")
                .msg("This is a test message.")
                .build();

        String someStringArg = "some string argument";

        emailService.sendPropertyEnquiryEmail(dto, someStringArg);
    }

}
