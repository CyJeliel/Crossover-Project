package com.crossover.project.domain.enumerations;

import lombok.Getter;

public enum UserStatusEnum {

    LOGGED(""), NOT_LOGGED("Invalid user or password");

    @Getter
    private String feedback;

    private UserStatusEnum(String feedback) {

        this.feedback = feedback;

    }
}
