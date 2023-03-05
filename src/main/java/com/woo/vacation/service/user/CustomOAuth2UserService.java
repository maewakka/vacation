package com.woo.vacation.service.user;

import com.woo.vacation.entity.user.User;
import com.woo.vacation.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Collections;

@Service
@Transactional
@Slf4j
@RequiredArgsConstructor
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final HttpSession httpSession;


    /**
     * Oauth 로그인 후 인가 토큰을 받은 뒤 실행되는 함수
     * 토큰을 바탕으로 사용자 정보를 받아 온 후 로직을 처리하는 함수이다.
     * @param OAuth2UserRequest
     * @return Authentication
     */
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        // 인가 토큰을 통해 OAuth 서버에서 사용자 정보를 받아온다.
        OAuth2User oAuth2User = super.loadUser(userRequest);
        // registrationId : OAuth 서버 종류(kakao, google 등)
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        // 유저 정보가 담긴 attribute를 뽑아낸다.
        String userNAmeAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        // 서버에서 받은 attribute 정보를 바탕으로 OAuthAttribute 객체로 변환하여 리턴한다.
        OAuthAttributes attributes = OAuthAttributes.of(registrationId, userNAmeAttributeName, oAuth2User.getAttributes());

        Long id = Long.parseLong(oAuth2User.getAttributes().get("id").toString());
        User user = saveOrUpdate(id, attributes);

        return new CustomUserDetails(user, oAuth2User.getAttributes(), registrationId);
    }

    /**
     * OAuthAttribute 객체를 바탕으로 User 테이블에 저장 한다.
     * @param OAuthAttributes
     * @return User
     */
    private User saveOrUpdate(Long id, OAuthAttributes attributes) {
        User user = userRepository.findById(id).orElse(attributes.toEntity());

        return userRepository.save(user);
    }

}
