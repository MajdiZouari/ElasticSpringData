package com.elasticmajdi.elasticmajdi.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.elasticmajdi.elasticmajdi.dto.UserDto;
import com.elasticmajdi.elasticmajdi.mapper.UserMapper;
import com.elasticmajdi.elasticmajdi.model.UserModel;
import com.elasticmajdi.elasticmajdi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDto addUser(UserDto userDto) {
        UserModel userModel = UserMapper.INSTANCE.userDtoToUserModel(userDto);
        if(userModel.getId() == null) {
            userModel.setId(UUID.randomUUID());
        }
        return UserMapper.INSTANCE.userModelToUserDto(userRepository.save(userModel));
    }

    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

   public void deleteUserAll() {
        userRepository.deleteAll();
    }

    public UserDto findById(UUID userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        return UserMapper.INSTANCE.userModelToUserDto(userModel);
    }

    public List<UserDto> findUserByName(String userName) {
        return userRepository.findByFirstName(userName)
                .stream().map(UserMapper.INSTANCE::userModelToUserDto)
                .collect(Collectors.toList());
    }
}
