package com.easy_pan.back.infra.utils;

import jakarta.annotation.Resource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class MailUtils {
    @Value("${spring.mail.username}")
    private String from;
    @Resource
    private JavaMailSender mailSender;

    public boolean sendRegisterCode(String to, int code)  {
        return this.processEmailSend(to, " EasyPan 新用户注册", code);
    }

    public boolean sendPasswordResetCode(String to, int code) {
        return this.processEmailSend(to, " EasyPan 密码重置", code);
    }

    private boolean processEmailSend(String to, String subject, int code) {
        MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setSubject(subject);
            String messageTemplate = "您正在使用此邮箱进行%s，邮箱验证码为<h2> %d </h2>验证码将在60s后过期，请即使使用。\n" +
                    "如非本人操作，请忽略。";
            mimeMessageHelper.setText(String.format(messageTemplate, subject, code), true);
            this.mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
