package com.Waterboi.API;
import java.util.Objects;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
@Entity
public class WebUser {
    private @Id @GeneratedValue Long id;
    private String username;
    private String password;
    WebUser() {}
    WebUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public Long getId() {
        return this.id;
    }
    public String getUsername() {
        return this.username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if(!(o instanceof WebUser))
            return false;
        WebUser user = (WebUser) o;
        return Objects.equals(this.id, user.id) && Objects.equals(this.username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.username);
    }

    @Override
    public String toString() {
        return "User{" + "id=" + this.id + ", username='" + this.username + '\'' + '}';
    }
}
