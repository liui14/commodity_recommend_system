package com.recommend.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.Random;

@Slf4j
@Component
public class EmailUtil {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 生成6位随机数字验证码
     * @return 6位数字验证码
     */
    public static String generateCode() {
        // 使用Random类生成随机数
        Random random = new Random();
        // 使用StringBuilder提升性能
        StringBuilder code = new StringBuilder();

        // 生成6位随机数字
        for (int i = 0; i < 6; i++) {
            code.append(random.nextInt(10));
        }

        return code.toString();
    }

    /**
     * 发送验证码邮件
     * @param toEmail 收件人邮箱
     * @param code 验证码
     * @return 是否发送成功
     */
    public boolean sendVerificationCode(String toEmail, String code) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            // 设置发件人
            message.setFrom(fromEmail);
            // 设置收件人
            message.setTo(toEmail);
            // 设置邮件主题
            message.setSubject("验证码");
            // 设置邮件内容
            message.setText("[星星商城]您的验证码是：" + code + "，有效期为5分钟，请勿泄露给他人。");

            // 发送邮件
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            log.info("发送邮箱出错：{}",e.getMessage());
            return false;
        }
    }

    /**
     * 发送自定义主题和内容的邮件
     * @param toEmail 收件人邮箱
     * @param subject 邮件主题
     * @param content 邮件内容
     * @return 是否发送成功
     */
    public boolean sendEmail(String toEmail, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(fromEmail);
            message.setTo(toEmail);
            message.setSubject(subject);
            message.setText(content);

            mailSender.send(message);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
