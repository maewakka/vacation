package com.woo.vacation.service.user;

import com.woo.vacation.entity.user.Role;
import com.woo.vacation.entity.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Getter
@Slf4j
public class OAuthAttributes {

    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private Long id;
    private String nickname;
    private String email;
    private String profileImage;

    @Builder
    public OAuthAttributes(Map<String, Object> attributes, String nameAttributeKey, Long id, String nickname, String email, String profileImage) {
        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.profileImage = profileImage;
    }

    /**
     * socialName에 따라 OAuthAttribute 객체로 바꾸어준다.
     * @return OAuthAttributes
     */
    public static OAuthAttributes of(String socialName, String userNameAttributeName, Map<String, Object> attributes) {
        if("kakao".equals(socialName)) {
            return ofKakao(userNameAttributeName, attributes);
        }
        return null;
    }

    /**
     * attributes 객체에서 kakao_account와 profile 객체를 뽑은 뒤, email/nickname/thumbnail_image_url 정보를 OAuthAttributes 객체에 저장한다.
     * @return OAuthAttributes
     */
    private static OAuthAttributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> kakaoAccount = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> kakaoProfile = (Map<String, Object>) kakaoAccount.get("profile");
        String id = attributes.get("id").toString();

        return OAuthAttributes.builder()
                .id(Long.parseLong(id))
                .email((String) kakaoAccount.get("email"))
                .nickname((String) kakaoProfile.get("nickname"))
                .profileImage((String) kakaoProfile.get("thumbnail_image_url"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    /**
     * OAuthAttributes 객체를 User 객체로 변환한다.
     * @return User
     */
    public User toEntity() {
        return User.builder()
                .id(id)
                .email(email)
                .nickname(nickname)
                .profileImage(profileImage)
                .role(Role.ROLE_USER)
                .build();
    }

}
