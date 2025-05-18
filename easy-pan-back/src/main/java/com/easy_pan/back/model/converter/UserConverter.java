package com.easy_pan.back.model.converter;

import com.easy_pan.back.model.dto.SaveUserDTO;
import com.easy_pan.back.model.entity.UserInfoDO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mappings({
            @Mapping(source = "userID", target = "id"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "nickName", target = "nickName"),
            @Mapping(source = "avatar", target = "avatar"),
            @Mapping(source = "salt", target = "salt"),
            @Mapping(source = "password", target = "password"),
            @Mapping(source = "status", target = "status"),
            @Mapping(source = "usedSpace", target = "usedSpace"),
            @Mapping(source = "totalSpace", target = "totalSpace")
    })
    UserInfoDO SaveUserDTO2UserInfoDO(SaveUserDTO dto);
}
