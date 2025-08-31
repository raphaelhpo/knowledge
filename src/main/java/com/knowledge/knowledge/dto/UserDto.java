package com.knowledge.knowledge.dto;

import org.springframework.beans.BeanUtils;

import com.knowledge.knowledge.entity.UserEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String name;
    private String login;
    private String password;
    
    public UserDto(UserEntity userEntity) {
        BeanUtils.copyProperties(userEntity, this);
    }
}
