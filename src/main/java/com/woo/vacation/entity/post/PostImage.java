package com.woo.vacation.entity.post;

import com.woo.vacation.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class PostImage extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_image_id")
    private Long id;

    @Column(name = "post_order")
    private Long order;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @Builder
    public PostImage(Long order, String imageUrl, Post post) {
        this.order = order;
        this.imageUrl = imageUrl;
        this.post = post;
    }
}
