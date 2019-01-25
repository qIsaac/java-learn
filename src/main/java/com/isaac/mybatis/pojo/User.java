package com.isaac.mybatis.pojo;

import lombok.*;

import java.util.Date;

/**
 * @Author : Isaac
 * @Description:
 * @Date :Created in 9:30 2018/9/6
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;


}