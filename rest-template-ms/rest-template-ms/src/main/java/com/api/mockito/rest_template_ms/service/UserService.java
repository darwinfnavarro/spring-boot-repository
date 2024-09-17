package com.api.mockito.rest_template_ms.service;

import com.api.mockito.rest_template_ms.dto.UserDTO;
import com.api.mockito.rest_template_ms.entity.User;
import com.api.mockito.rest_template_ms.repository.JpaUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    @Value("${spring.external.service.base-url}")
    private String baseUrl;

    private final JpaUser jpaUser;
    private final RestTemplate restTemplate;

    public List<UserDTO> getUsers() {

        UserDTO[] response = restTemplate.getForObject(baseUrl, UserDTO[].class);

        if (response != null) {
            List<User> users = new ArrayList<>();
            for (UserDTO userDTO : response) {
                Long id = (userDTO.getId() != null) ? userDTO.getId().longValue() : null;
                User user = new User(
                        userDTO.getId().longValue(),
                        userDTO.getUsername(),
                        userDTO.getEmail(),
                        userDTO.getAvatar()
                );
                users.add(user);

            }
            jpaUser.saveAll(users);
        }
        return Arrays.asList(response != null ? response : new UserDTO[0]);
    }



    public void saveUser(UserDTO userDTO) {
        restTemplate.postForObject(baseUrl, userDTO, UserDTO.class);


        User user = new User(
                null, // id es generado automáticamente
                userDTO.getUsername(),
                userDTO.getEmail(),
                userDTO.getAvatar()
        );

        jpaUser.save(user);

    }

    public void updateUser(Integer id, UserDTO userDTO) throws UserNotFoundException {

        Optional<User> existingUser = jpaUser.findById(id.longValue());

        if (existingUser.isPresent()) {

            restTemplate.put(baseUrl + "/" + id, userDTO);

            User user = existingUser.get();
            user.setUsername(userDTO.getUsername());
            user.setEmail(userDTO.getEmail());
            user.setAvatar(userDTO.getAvatar());

            jpaUser.save(user);
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }
    }

    public void deleteUser(Integer id) throws UserNotFoundException {
        Optional<User> user = jpaUser.findById(id.longValue());

        if (user.isPresent()) {
            restTemplate.delete(baseUrl + "/" + id);
            jpaUser.deleteById(id.longValue());
        } else {
            throw new UserNotFoundException("User with ID " + id + " not found");
        }


    }



}
