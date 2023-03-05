package com.woo.vacation.repository.vacation;

import com.woo.vacation.entity.vacation.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}
