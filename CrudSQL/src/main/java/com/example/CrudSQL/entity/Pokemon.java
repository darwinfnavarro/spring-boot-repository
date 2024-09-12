package com.example.CrudSQL.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "pokemon")
public class Pokemon {

    public static Object Move;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String pokemonName;
    private String type;
    private LocalDateTime searchDate;

    @ElementCollection
    @CollectionTable(name = "pokemon_attacks", joinColumns = @JoinColumn(name = "pokemon_id"))
    @Column(name = "attack")
    private List<String> attacks;

    @ElementCollection
    @CollectionTable(name = "pokemon_types", joinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Type> types;

    @ElementCollection
    @CollectionTable(name = "pokemon_moves", joinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Move> moves;
}
