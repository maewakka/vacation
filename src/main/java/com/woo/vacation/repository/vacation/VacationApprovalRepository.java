package com.woo.vacation.repository.vacation;

import com.woo.vacation.entity.vacation.VacationApproval;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationApprovalRepository extends JpaRepository<VacationApproval, Long> {
}
