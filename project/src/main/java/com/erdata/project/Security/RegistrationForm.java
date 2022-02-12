package com.erdata.project.Security;


import org.hibernate.validator.constraints.Length;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegistrationForm{
    @NotNull
    @Size(min = 3, message = "Username must contain at least 3 characters")
    private String username;
    @NotNull
    @Size(min = 5, message = "Password must contain at least 5 characters")
    private String password;
    @Length(min = 10,max = 10, message = "Phone number must contain 10 digits." )
    @Digits(integer = 10, fraction = 0, message = "Phone number must be digits.")
    private String phone;
    @NotNull
    @Size(min = 3, message = "First name must contain at least 3 characters")
    private String firstName;

    private String middleName;
    @NotNull
    @Size(min = 3, message = "Last name must contain at least 3 characters")
    private String lastName;
    @NotBlank(message = "Please choose gender")
    private String gender;
    @NotBlank(message = "Address must not be blank.")
    private String address;


    User toUser(PasswordEncoder encoder) {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(encoder.encode(this.password));
        user.setPhone(this.phone);
        user.setGender(this.gender);
        user.setAddress(this.address);
        user.setMiddleName(this.middleName);
        user.setLastName(this.lastName);
        user.setFirstName(this.firstName);
        user.setRole("ROLE_USER");
        return user;
    }
}