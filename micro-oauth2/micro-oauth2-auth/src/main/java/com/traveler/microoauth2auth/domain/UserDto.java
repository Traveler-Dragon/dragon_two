package com.traveler.microoauth2auth.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private Integer status;
    private List<String> roles;
}
