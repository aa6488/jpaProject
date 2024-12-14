package com.jpaProject.study.user.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
public class UserDTO {

    private Long userNo;
    private String userName;
    private String userId;
    private String userPwd;
    private LocalDateTime userCreateDate;
    private LocalDateTime userDeleteDate;
    private LocalDateTime userLoginDate;
}
