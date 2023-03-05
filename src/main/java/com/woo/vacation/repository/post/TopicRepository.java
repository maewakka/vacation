package com.woo.vacation.repository.post;

import com.woo.vacation.entity.post.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
