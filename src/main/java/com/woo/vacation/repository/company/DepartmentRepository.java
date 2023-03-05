package com.woo.vacation.repository.company;

import com.woo.vacation.entity.company.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
