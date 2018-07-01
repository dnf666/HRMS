package com.facishare.crm.stock.predefine.manager;

import com.facishare.crm.constants.SystemConstants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Deprecated
public class LifeStatusChangeExecutor {
    private LifeStatusChange lifeStatusChange;

    public LifeStatusChangeExecutor(LifeStatusChange lifeStatusChange) {
        this.lifeStatusChange = lifeStatusChange;
    }

    public void doChange(String oldLifeStatus, String newLifeStatus) {
        log.info("{}->{}",oldLifeStatus,newLifeStatus);
        if (SystemConstants.LifeStatus.Ineffective.value.equals(oldLifeStatus)) {
            if (SystemConstants.LifeStatus.UnderReview.value.equals(newLifeStatus)) {
                lifeStatusChange.ineffectiveToUnderReview();
            } else if (SystemConstants.LifeStatus.Normal.value.equals(newLifeStatus)) {
                lifeStatusChange.ineffectiveToNormal();
            } else {
                log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
            }
        } else if (SystemConstants.LifeStatus.UnderReview.value.equals(oldLifeStatus)) {
            if (SystemConstants.LifeStatus.Ineffective.value.equals(newLifeStatus)) {
                lifeStatusChange.underReviewToIneffective();
            } else if (SystemConstants.LifeStatus.Normal.value.equals(newLifeStatus)) {
                lifeStatusChange.underReviewToNormal();
            } else {
                log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
            }
        } else if (SystemConstants.LifeStatus.Normal.value.equals(oldLifeStatus)) {
            if (SystemConstants.LifeStatus.InChange.value.equals(newLifeStatus)) {
                lifeStatusChange.normalToInChange();
            } else if (SystemConstants.LifeStatus.Invalid.value.equals(newLifeStatus)) {
                lifeStatusChange.normalToInvalid();
            } else {
                log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
            }
        } else if (SystemConstants.LifeStatus.InChange.value.equals(oldLifeStatus)) {
            if (SystemConstants.LifeStatus.Normal.value.equals(newLifeStatus)) {
                lifeStatusChange.inChangeToNormal();
            } else if (SystemConstants.LifeStatus.Invalid.value.equals(newLifeStatus)) {
                lifeStatusChange.inChangeToInvalid();
            } else {
                log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
            }
        } else if (SystemConstants.LifeStatus.Invalid.value.equals(oldLifeStatus)) {
            if (SystemConstants.LifeStatus.Normal.value.equals(newLifeStatus)) {
                lifeStatusChange.invalidToNormal();
            } else {
                log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
            }
        } else {
            log.warn("NotFound oldLifeStatus={},newLifeStatus={}", oldLifeStatus, newLifeStatus);
        }
    }

    public static interface LifeStatusChange {
        public void ineffectiveToUnderReview();

        public void ineffectiveToNormal();

        public void underReviewToNormal();

        public void underReviewToIneffective();

        public void normalToInChange();

        public void normalToInvalid();

        public void inChangeToInvalid();

        public void inChangeToNormal();

        public void invalidToNormal();
    }
}
