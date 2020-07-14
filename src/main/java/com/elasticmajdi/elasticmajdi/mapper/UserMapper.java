package com.elasticmajdi.elasticmajdi.mapper;

import com.elasticmajdi.elasticmajdi.dto.UserDto;
import com.elasticmajdi.elasticmajdi.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserModel userDtoToUserModel(UserDto userDto);

    UserDto userModelToUserDto(UserModel userModel);
}
