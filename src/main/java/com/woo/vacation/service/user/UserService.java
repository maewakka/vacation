package com.woo.vacation.service.user;

import com.woo.vacation.dto.user.UserInformDto;
import com.woo.vacation.entity.user.User;
import com.woo.vacation.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserInformDto getUserInform(User user) {
        return UserInformDto.builder()
                .email(user.getEmail())
                .nickname(user.getNickname())
                .profileImage(user.getProfileImage())
                .leftOff(user.getLeftOff() != null ? user.getLeftOff() : 0)
                .company(user.getCompany() != null ? user.getCompany().getName() : null)
                .department(user.getDepartment() != null ? user.getDepartment().getName() : null)
                .build();
    }

}
