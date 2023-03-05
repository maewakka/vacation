package com.woo.vacation.entity.user;

import com.woo.vacation.entity.BaseTimeEntity;
import com.woo.vacation.entity.company.Company;
import com.woo.vacation.entity.company.Department;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Data
public class User extends BaseTimeEntity {

    @Id
    @Column(name = "user_id", unique = true)
    private Long id;

    @Column(unique = true)
    private String email;
    private String nickname;

    @Column(name = "profile_image")
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne
    @JoinColumn(name = "company")
    private Company company;

    @OneToOne
    @JoinColumn(name = "department")
    private Department department;

    @Column(name = "left_off")
    private Long leftOff;

    @Builder
    public User(Long id, String email, String nickname, String profileImage, Role role, Company company, Department department, Long leftOff) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.role = role;
        this.company = company;
        this.department = department;
        this.leftOff = leftOff;
    }
}
