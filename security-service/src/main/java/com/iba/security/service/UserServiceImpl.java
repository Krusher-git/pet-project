package com.iba.security.service;

import com.iba.library.client.MainProcessorFeignClient;
import com.iba.library.dto.req.security.UserReq;
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
                            log.error("Error occurred while getting role " + ROLE_USER);
                            return new RuntimeException("Error with user, replace someday");
                        })
        );

        final User savedUser = userRepository.save(newUser);

        mainProcessorFeignClient.createCartWithUserId(savedUser.getId());

        return userMapper.toResponse(savedUser);
    }

    @Override
    public UserResp getUserById(Long id) {
        final User user = userRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Error with user with id " + id);
                    return new RuntimeException("Error with user, replace someday");
                });

        return userMapper.toResponse(user);
    }

}
