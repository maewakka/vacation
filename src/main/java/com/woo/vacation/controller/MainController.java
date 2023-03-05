package com.woo.vacation.controller;

import com.woo.vacation.dto.user.UserInformDto;
import com.woo.vacation.service.user.CustomUserDetails;
import com.woo.vacation.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MainController {

    private final UserService userService;

    @GetMapping("/main")
    public String main(Principal principal, Model model) {
        if(principal != null) {
            CustomUserDetails userDetails = (CustomUserDetails) ((Authentication) principal).getPrincipal();
            UserInformDto userInform = userService.getUserInform(userDetails.getUser());

            model.addAttribute("userInform", userInform);
            return "main";
        }

        return "main";
    }

}
