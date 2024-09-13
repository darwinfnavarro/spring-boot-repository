package com.api.mockito.rest_template_ms.dto;

import lombok.Data;

@Data //Lombok se usa
public class UserDTO {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private String avatar;


}
