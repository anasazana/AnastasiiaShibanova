package ru.training.at.hw8.data.entities;

import com.epam.jdi.tools.DataClass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DataClass<User> {

    public static User DEFAULT_USER = new User("Roman", "Jdi1234", "ROMAN IOVLEV");

    public String name;
    public String password;
    public String fullName;

    public User(String username, String password, String fullName) {
        this.name = username;
        this.password = password;
        this.fullName = fullName;
    }

}
