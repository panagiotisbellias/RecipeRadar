package com.github.donaldwilson8.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
public class User {

    @Id
    private String _id;
    @Field("username")
    private String username;
    @Field("password")
    private String password;
    @Field("email")
    private String email;
    @Field("phone")
    private String phone;
    @Field("name")
    private String name;
    @Field("age")
    private int age;
    @Field("gender")
    private String gender;
    @Field("dietaryRestrictions")
    private String[] dietaryRestrictions;

    public User(){
    }

    public User(String _id, String username, String password, String email, String phone, String name, int age, String gender, String[] dietaryRestrictions){
        this._id = _id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.dietaryRestrictions = dietaryRestrictions;
    }


    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getDietaryRestrictions() {
        return dietaryRestrictions;
    }

    public void setDietaryRestrictions(String[] dietaryRestrictions) {
        this.dietaryRestrictions = dietaryRestrictions;
    }
}
