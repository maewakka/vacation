package com.woo.vacation.entity.notification;

import com.woo.vacation.entity.BaseTimeEntity;
import com.woo.vacation.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "notification_id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User writer;

    @Builder
    public Notification(String content, User writer) {
        this.content = content;
        this.writer = writer;
    }
}
