package com.szx.server.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * 登录传入用户名密码
 */
@Data
// 生成 equals 和 hashCode=方法
@EqualsAndHashCode(callSuper = false)
// chain为一个布尔值，如果为true生成的set方法返回this，为false生成的set方法是void类型。
// 默认为false，除非当fluent为true时，chain默认则为true
@Accessors(chain = true)
@ApiModel(value = "adminLogin", description = "用户登录")
public class AdminLogin {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
    @ApiModelProperty(value = "验证码", required = true)
    private String code;
}
