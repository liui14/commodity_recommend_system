package com.recommend.controller;


import com.recommend.common.Response;
import com.recommend.domain.dto.login.EmailCodeDTO;
import com.recommend.domain.dto.login.RegisterDTO;
import com.recommend.domain.vo.EmailVO;
import com.recommend.domain.vo.ImageVO;
import com.recommend.service.email.EmailService;
import com.recommend.service.login.LoginService;
import com.recommend.service.verify.VerifyService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/login")
public class LoginController {


    private final LoginService loginService;
    private final VerifyService verifyService;
    private final EmailService emailService;

    public LoginController(LoginService loginService, VerifyService verifyService, EmailService emailService) {
        this.loginService = loginService;
        this.verifyService = verifyService;
        this.emailService = emailService;
    }

    @GetMapping("/image/v1")
    public Response<ImageVO> getVerCodeImage() throws IOException {
        ImageVO imageVO = verifyService.create();
        if (imageVO == null) {
            return Response.errorMsg("验证码生成失败");
        }else {
            return Response.succData(imageVO, "验证码生成成功");
        }
    }

    @PostMapping("/email/v1")
    public Response<String> getEmailCode(@Validated @RequestBody EmailCodeDTO emailCodeDTO) {
        String toEmail = emailCodeDTO.getEmail();
        try {
            EmailVO emailVO = emailService.create(toEmail);
            if (emailVO == null) {
                return Response.errorMsg("邮件发送失败");
            }else {
                return Response.succData(emailVO.getEmailToken(), "邮件发送成功，请查收验证码");
            }
        } catch (IOException e) {
            log.info("邮件发送失败，{}", e.getMessage());
            return Response.errorMsg("邮件发送失败");
        }
    }

    @PostMapping("/register/v1")
    public Response<String> register(@Validated @RequestBody RegisterDTO registerDTO){
        String toEmail = registerDTO.getEmail();
        String uname = registerDTO.getUname();
        String upass = registerDTO.getUpass();

        return null;

    }
}
