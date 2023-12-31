package com.javagram;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.javagram.validation.Age;
import com.javagram.validation.Username;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;

public class User {
  
  @NotBlank( message = "First name cannot be blank")
  @Size(min = 2, message = "First name is too short")
  private String firstName;

  @NotBlank( message = "Last name cannot be blank")
  @Size(min = 2, message = "Last name is too short")
  private String lastName;

  @NotBlank( message = "Username cannot be blank")
  @Size(min = 7, message = "Username is too short")
  @Username(message = "Cannot contain special characters or uppercase characters")
  private String username;

  @NotBlank( message = "Username cannot be blank")
  @Email(message = "Invlid email address")
  private String email;

  @Past(message = "Date of birth must be in the past")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Age(message = "Must be at least 18")
  private Date dateOfBirth;

  public User() {
  }

  public User(String firstName, String lastName, String username, String email, Date dateOfBirth) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDateOfBirth() {
    return this.dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

}
