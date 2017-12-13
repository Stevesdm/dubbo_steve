package com.steve.model;

import com.steve.framework.core.validator.DeleteValidatorGroup;
import com.steve.framework.core.validator.InsertValidatorGroup;
import com.steve.framework.core.validator.SelectValidatorGroup;
import com.steve.framework.core.validator.UpdateValidatorGroup;
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
public class User implements Serializable {

    @Id //使用tk mapper model主键需有标识
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "参数[userId]不能为空", groups = {UpdateValidatorGroup.class, DeleteValidatorGroup.class, SelectValidatorGroup.class})
    private Integer userId;

    @NotNull(message = "参数[userName]不能为空", groups = {InsertValidatorGroup.class})
    private String userName;

    @NotNull(message = "参数[password]不能为空", groups = InsertValidatorGroup.class)
    private String password;

    private Integer active;

    private Integer roleId;


}