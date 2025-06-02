package com.easy_pan.model.converter;

import com.easy_pan.model.pojo.dto.SaveTokenDTO;
import com.easy_pan.model.pojo.entity.UserTokenDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserTokenConverter {
    UserTokenConverter INSTANCE = Mappers.getMapper(UserTokenConverter.class);

    UserTokenDO saveTokenDto2UserTokenDO(SaveTokenDTO dto);
}
