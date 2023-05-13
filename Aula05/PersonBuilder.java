package Aula05;

import java.util.List;

public class PersonBuilder {
    public static List<Person> getAllPersons() {
        return List.of(
                new Person("Regis", 36),
                new Person("Daniele", 23),
                new Person("João", 40),
                new Person("Maria", 28),
                new Person("Pedro", 32),
                new Person("Ana", 45),
                new Person("Carlos", 19),
                new Person("Mariana", 31),
                new Person("Lucas", 27),
                new Person("Julia", 39),
                new Person("Rafael", 24),
                new Person("Patricia", 37),
                new Person("Fernando", 42),
                new Person("Camila", 29),
                new Person("Guilherme", 33),
                new Person("Isabela", 22),
                new Person("Marcelo", 47),
                new Person("Larissa", 26),
                new Person("Ricardo", 34),
                new Person("Vanessa", 41)
        );
    }
}
