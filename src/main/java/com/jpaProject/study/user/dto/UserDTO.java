package com.jpaProject.study.user.dto;

import jakarta.persistence.Column;
import lombok.Data;

import java.sql.Date;

@Data
public class UserDTO {

    private Long userNo;
    private String userName;
    private String userId;
    private String userPwd;
    private Date userCreateDate;
    private Date userDeleteDate;
    private Date userLoginDate;
}
