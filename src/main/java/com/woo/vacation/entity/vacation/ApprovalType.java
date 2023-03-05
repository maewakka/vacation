package com.woo.vacation.entity.vacation;

public enum ApprovalType {
    APPROVAL("승인"),
    CANCELLATION("반려"),
    SUPPLEMENT("보완");

    String type;
    ApprovalType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
