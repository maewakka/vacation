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
public class PostComment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_comment_id")
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "writer")
    private User writer;

    @ManyToOne
    @JoinColumn(name = "post")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_comment")
    private PostComment parentComment;

    @Enumerated(EnumType.STRING)
    private CommentType commentType;

    @Builder
    public PostComment(String content, User writer, Post post, PostComment parentComment, CommentType commentType) {
        this.content = content;
        this.writer = writer;
        this.post = post;
        this.parentComment = parentComment;
        this.commentType = commentType;
    }
}
