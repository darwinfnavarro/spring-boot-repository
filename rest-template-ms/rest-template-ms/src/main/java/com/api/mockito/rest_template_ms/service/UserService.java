package com.api.mockito.rest_template_ms.service;

import com.api.mockito.rest_template_ms.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor

public class UserService {

    @Value("${spring.external.service.base-url}")
    private String baseUrl;

private final RestTemplate restTemplate;

    public List<UserDTO>getUsers(){

       UserDTO[] response=  restTemplate.getForObject(baseUrl,UserDTO[].class);

       return Arrays.asList(response);
    }

    public void saveUser(UserDTO userDTO){

        restTemplate.postForObject(baseUrl,userDTO,UserDTO.class);
    }

    public void updateUser(Integer id, UserDTO userDTO) {
        restTemplate.put(baseUrl + "/" + id, userDTO);
    }


    public void deleteUser(Integer id){
        restTemplate.put(baseUrl,id);
    }

}
