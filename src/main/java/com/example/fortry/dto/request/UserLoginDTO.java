package com.example.fortry.dto.request;
import lombok.Data;

@Data
public class UserLoginDTO {
//    @NotBlank(message="用户名不能为空")
    private String username;
//    @Size(min=6,message="长度不少于6位")
    private String password;
}
