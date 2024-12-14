package com.jpaProject.study.user.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_no")
    private Long userNo;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_create_date")
    private LocalDateTime userCreateDate;

    @Column(name = "user_delete_date")
    private LocalDateTime userDeleteDate;

    @Column(name = "user_login_date")
    private LocalDateTime userLoginDate;


}
