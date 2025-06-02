package com.easy_pan.model.converter;

import com.easy_pan.account.UserLoginData;
import com.easy_pan.model.pojo.dto.SaveUserDTO;
import com.easy_pan.model.pojo.entity.UserInfoDO;
import com.easy_pan.model.pojo.vo.UserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mappings({
            @Mapping(source = "userID", target = "id")
    })
    UserInfoDO SaveUserDTO2UserInfoDO(SaveUserDTO dto);

    @Mappings({
            @Mapping(source = "id", target = "userID")
    })
    UserLoginData UserInfoDO2UserLoginData(UserInfoDO user);

    @Mappings({
            @Mapping(source = "id", target = "userID")
    })
    UserInfoVO UserInfoDO2UserInfoVO(UserInfoDO user);
}
