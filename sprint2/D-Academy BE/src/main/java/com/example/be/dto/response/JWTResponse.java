package com.example.be.dto.response;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JWTResponse {
    private String token;
    private String type = "Bearer";
    private String name;
    private int id;
    private String username;
    private String email;
    private String password;
    private String avatar;
    private String phoneNumber;
    private String address;
    private Boolean gender;
    private String dateOfBirth;
    private Collection<? extends GrantedAuthority> roles;

    public JWTResponse() {
    }

    public JWTResponse(String token, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = name;
        this.roles = roles;
    }

    public JWTResponse(String token, String name, int id, String username, String email, String password, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.name = name;
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.avatar = avatar;
    }

    public JWTResponse(String token, String type, String name, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.name = name;
        this.roles = roles;
    }

    public JWTResponse(String token, String name, Integer id, String username, String email, String password, String avatar,
                       String phoneNumber,
                       String address,
                       Boolean gender,
                       String dateOfBirth
            , Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.name = name;
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.roles = authorities;
    }

    public JWTResponse(String token, Integer id, String name, Collection<? extends GrantedAuthority> authorities) {
        this.token = token;
        this.id = id;
        this.name = name;
        this.roles = authorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Collection<? extends GrantedAuthority> getRoles() {
        return roles;
    }

    public void setRoles(Collection<? extends GrantedAuthority> roles) {
        this.roles = roles;
    }
}
