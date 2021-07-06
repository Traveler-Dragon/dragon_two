package com.traveler.server.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;


@Data
@ApiModel(value = "登录",description = "获取的登录信息")
public class LoginDto {

    @ApiModelProperty("用户名")
    @NotBlank(message = "用户名的信息不能为空")
    private String username;


    @ApiModelProperty("密码")
    @NotBlank(message = "密码不能为空")
    private String password;
}
