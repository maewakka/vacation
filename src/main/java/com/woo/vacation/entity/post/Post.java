package com.woo.vacation.entity.post;

import com.woo.vacation.entity.BaseTimeEntity;
import com.woo.vacation.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "topic")
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User writer;

    @Builder
    public Post(String content, Topic topic, User writer) {
        this.content = content;
        this.topic = topic;
        this.writer = writer;
    }
}
