package com.woo.vacation.entity.vacation;

import com.woo.vacation.entity.BaseTimeEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Vacation extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_id")
    private Long id;

    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "end_date")
    private LocalDateTime endDate;

    private String reason;

    @Column(name = "vacation_type")
    @Enumerated(EnumType.STRING)
    private VacationType vacationType;

    @Column(name = "certification_url")
    private String certificationUrl;

    @Builder
    public Vacation(LocalDateTime startDate, LocalDateTime endDate, String reason, VacationType vacationType, String certificationUrl) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.vacationType = vacationType;
        this.certificationUrl = certificationUrl;
    }
}
