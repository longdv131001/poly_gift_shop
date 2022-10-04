package com.poly.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Random;

@RestController
@CrossOrigin("*")
@RequestMapping("/send-mail")
@RequiredArgsConstructor
public class MailController {

    private final JavaMailSender javamail;

    @GetMapping("/{mail}")
    public HashMap<String, Object> send(@PathVariable("mail") String mail) {
        Random rd = new Random();
        String code = "PL" + rd.nextInt(20001) + 80000;
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(mail);
        msg.setSubject("Mã kích hoạt");
        msg.setText(code);
        javamail.send(msg);
        HashMap<String, Object> map = new HashMap<>();
        map.put("results", code);
        return map;
    }
}
