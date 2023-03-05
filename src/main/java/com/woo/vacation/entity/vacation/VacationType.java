package com.woo.vacation.entity.vacation;

public enum VacationType {
    DAY_OFF("연차"),
    MORNING_OFF("오전 반가"),
    AFTERNOON_OFF("오후 반가"),
    SICK_OFF("병가"),
    PUBLIC_OFF("공가"),
    TIME_OFF("연차 시간 사용");

    String off;

    VacationType(String off) {
        this.off = off;
    }

    public String getOff() {
        return off;
    }
}
