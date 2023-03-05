package com.woo.vacation.entity.vacation;

import com.woo.vacation.entity.BaseTimeEntity;
import com.woo.vacation.entity.user.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class VacationApproval extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vacation_approval_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "approval")
    private User approval;

    @ManyToOne
    @JoinColumn(name = "applicant")
    private User applicant;

    @OneToOne
    @JoinColumn(name = "vacation")
    private Vacation vacation;

    private String comment;

    @Column(name = "vacation_type")
    @Enumerated(EnumType.STRING)
    private VacationType vacationType;

    @Builder
    public VacationApproval(User approval, User applicant, Vacation vacation, String comment, VacationType vacationType) {
        this.approval = approval;
        this.applicant = applicant;
        this.vacation = vacation;
        this.comment = comment;
        this.vacationType = vacationType;
    }
}
