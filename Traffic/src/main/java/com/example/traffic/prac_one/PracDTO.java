package com.example.traffic.prac_one;

import lombok.Data;

@Data
public class PracDTO {

    private Long id;

    private String name;

    private int age;

    private String email;

    public PracDTO(Long id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public PracEntity toEntity() {
        return PracEntity.builder()
                .id(id)
                .name(name)
                .age(age)
                .email(email)
                .build();
    }


}
