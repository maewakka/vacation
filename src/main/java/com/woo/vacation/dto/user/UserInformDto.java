package com.woo.vacation.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
public class UserInformDto {

    private String nickname;
    private String profileImage;
    private String email;
    private Long leftOff;
    private String company;
    private String department;

    @Builder
    public UserInformDto(String nickname, String profileImage, String email, Long leftOff, String company, String department) {
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.email = email;
        this.leftOff = leftOff;
        this.company = company;
        this.department = department;
    }
}
