package com.shubham.projects.journal.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {
    private String userName;
    private String newPassword;
    // getters/setters
}
