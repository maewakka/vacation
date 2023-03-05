package com.woo.vacation.repository.post;

import com.woo.vacation.entity.post.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
