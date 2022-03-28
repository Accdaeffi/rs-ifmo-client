package ru.dnoskov.rsifmo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
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
