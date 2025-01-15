package com.recommend.controller;


import com.recommend.common.Response;
import com.recommend.domain.dto.login.EmailCodeDTO;
import com.recommend.domain.dto.login.RegisterDTO;
import com.recommend.domain.po.UserPO;
import com.recommend.domain.vo.EmailVO;
import com.recommend.domain.vo.ImageVO;
import com.recommend.service.email.EmailService;
import com.recommend.service.login.LoginService;
import com.recommend.service.user.UserService;
import com.recommend.service.verify.VerifyService;

import com.recommend.util.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final UserService userService;

    public LoginController(LoginService loginService, VerifyService verifyService, EmailService emailService, UserService userService) {
        this.loginService = loginService;
        this.verifyService = verifyService;
        this.emailService = emailService;
        this.userService = userService;
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
        String email = registerDTO.getEmail();
        String emailCode = registerDTO.getEmailCode();
        String uname = registerDTO.getUname();
        String upass = registerDTO.getUpass();

        if(!emailService.verify(emailCode)){
            return Response.errorMsg("验证码错误");
        }

        try {
            UserPO userPO = new UserPO();
            userPO.setEmail(email);
            userPO.setUserName(uname);
            userPO.setPassword(HashUtil.hashPassword(upass));
            userPO.setLoginType(1);
            userPO.setCreateTime(System.currentTimeMillis());
            userPO.setUpdateTime(System.currentTimeMillis());
            userService.save(userPO);
            return Response.succ();
        }catch (Exception e){
            return Response.errorMsg("注册失败");
        }


    }
}
