package ru.dnoskov.rsifmo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person {

    private int id;
    private String name;
    private String patronymic;
    private String surname;
    private int age;

    public Person(String name, String surname, String patronymic, int age) {
        this.age = age;
        this.name = name;
        this.patronymic = patronymic;
        this.surname = surname;
        this.id = 0;
	}

}
