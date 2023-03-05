package com.woo.vacation.repository.post;

import com.woo.vacation.entity.post.PostImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostImageRepository extends JpaRepository<PostImage, Long> {
}
