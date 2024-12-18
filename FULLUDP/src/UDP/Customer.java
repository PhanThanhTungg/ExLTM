package UDP;

import java.io.Serializable;

public class Customer implements Serializable {
  private static final long serialVersionUID = 20151107; 
  private String id, code, name, dayOfBirth, userName ;

  
  public Customer() {
  }
  @Override
  public String toString() {
    return "Customer [id=" + id + ", code=" + code + ", name=" + name + ", dayOfBirth=" + dayOfBirth + ", userName="
        + userName + "]";
  }
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getDayOfBirth() {
    return dayOfBirth;
  }
  public void setDayOfBirth(String dayOfBirth) {
    this.dayOfBirth = dayOfBirth;
  }
  public String getUserName() {
    return userName;
  }
  public void setUserName(String userName) {
    this.userName = userName;
  }
  
}
