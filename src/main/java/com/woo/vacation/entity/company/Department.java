package com.woo.vacation.entity.company;

import com.woo.vacation.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Department extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long id;

    @Column(name = "department_name")
    private String name;
    @Column(name = "department_personnel")
    private Long people;

    @Builder
    public Department(String name, Long people) {
        this.name = name;
        this.people = people;
    }
}
