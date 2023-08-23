package com.codegym.form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.lang.annotation.Annotation;

public class UserDto implements Validator {
    @NotEmpty(message = "Not Empty")
    @Size(min = 5,max = 45)
    private String name;

    @Min(18)
    private int age;
    @Email
    private String email;
    private String numberPhone;

    public UserDto() {
    }

    public UserDto(String name, String numberPhone, int age, String email) {

        this.name = name;
        this.numberPhone = numberPhone;
        this.age = age;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getNumberPhone().equals("")){
            errors.rejectValue("numberPhone",null,"Không được để Trống ");
        } else if (!userDto.getNumberPhone().matches("^0[0-9\\s.-]{9,11}$")) {
            errors.rejectValue("numberPhone",null,"Không đúng đinh dạng");
        }
    }
}
