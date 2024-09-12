package com.example.CrudSQL.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class Move {

    private MoveDetail move;

    @Data
    @Embeddable
    public static class MoveDetail {
        private String name;
        private String url;
    }
}
