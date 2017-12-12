package com.steve.model;

import com.steve.validator.InsertValidatorGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable{

    @Id //使用tk mapper model主键需有标识
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;

    @NotNull(message = "参数[userName]不能为空", groups = InsertValidatorGroup.class)
    private String userName;

    @NotNull(message = "参数[password]不能为空", groups = InsertValidatorGroup.class)
    private String password;

    private Integer active;

    private Integer roleId;


}