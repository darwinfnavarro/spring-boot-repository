package com.example.CrudSQL.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Type {

    private TypeDetail type;

    @Data
    @Embeddable
    public static class TypeDetail {
        private String name;
        private String url;
    }
}
