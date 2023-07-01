package com.hackathon.sic.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    INSTRUCTOR_READ("instructor:read"),
    INSTRUCTOR_UPDATE("instructor:update"),
    INSTRUCTOR_CREATE("instructor:create"),
    INSTRUCTOR_DELETE("instructor:delete"),

    STUDENT_READ("landlord:read"),
    STUDENT_UPDATE("landlord:update"),
    STUDENT_CREATE("landlord:create"),
    STUDENT_DELETE("landlord:delete")


            ;

    @Getter
    private final String permission;
}
