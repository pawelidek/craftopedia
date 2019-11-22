package com.javadevwannabes.craftopedia;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class UserDto {

  @NotNull
  @NotEmpty
  private String firstName;

  @NotNull
  @NotEmpty
  private String lastName;

  @NotNull
  @NotEmpty
  private String passwortd;
  private String machingPassword;

  @NotNull
  @NotEmpty
  private String email;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPasswortd() {
    return passwortd;
  }

  public void setPasswortd(String passwortd) {
    this.passwortd = passwortd;
  }

  public String getMachingPassword() {
    return machingPassword;
  }

  public void setMachingPassword(String machingPassword) {
    this.machingPassword = machingPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
