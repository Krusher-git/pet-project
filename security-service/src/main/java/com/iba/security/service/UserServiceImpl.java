package com.iba.security.service;

import com.iba.library.client.MainProcessorFeignClient;
import com.iba.library.dto.req.security.UserReq;
import com.iba.library.dto.resp.SimpleIDResp;
import com.iba.library.dto.resp.security.UserResp;
import com.iba.security.entity.User;
import com.iba.security.mapper.UserMapper;
import com.iba.security.repository.RoleRepository;
import com.iba.security.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

@AllArgsConstructor
@Service
@Log4j2
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final MainProcessorFeignClient mainProcessorFeignClient;

    private final String ROLE_USER = "ROLE_USER";

    @Override
    @Transactional
    public UserResp createUser(UserReq userReq) {
        final User newUser = userMapper.toEntity(userReq);
        String password = userReq.getPassword();

        newUser.setPassword(passwordEncoder.encode(password));

        newUser.setRole(
                roleRepository.findByName(ROLE_USER)
                        .orElseThrow(() -> {

                            log.error("UserService.createUser.roleRepository: Error occurred while getting role " + ROLE_USER);

                            return new RuntimeException("Error with user, replace someday");
                        })
        );

        final User savedUser = userRepository.save(newUser);

        final SimpleIDResp idResp = mainProcessorFeignClient.createCartWithUserId(savedUser.getId()).getBody();

        if (Objects.isNull(idResp)) {
            log.error("UserService.createUser: Error occurred during creating cart: idResp is NUll");

            throw new RuntimeException("smth useful");
        }

        savedUser.setCartId(idResp.getId());

        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResp getUserById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> {

                    log.error("UserService.getUserById.roleRepository: Error getting with id " + id);

                    return new RuntimeException("Error with user, replace someday");
                });

        return userMapper.toResponse(user);
    }

}
