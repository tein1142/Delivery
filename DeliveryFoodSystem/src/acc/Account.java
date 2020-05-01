/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package acc;

import DBservice.DatabaseSystem;
import person.PersonProfile;
import java.util.Objects;


enum LoginStatus{
    Login, Logout, Unsign, NotSetProfile
}
public abstract class Account {
    private String username;
    private String password;
    private LoginStatus loginStatus;
    private PersonProfile person;

    public Account(Account account){
        this.username=account.username;
        this.password=account.password;
        this.person=account.person;
    }
    
    public Account(String username, String password, PersonProfile person) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.loginStatus = loginStatus.Login;
    }

    public String getUsername() {
        return username;
    }

    public LoginStatus getLoginStatus() {
        return loginStatus;
    }

    public PersonProfile getPerson() {
        return person;
    }

    public void setPerson(PersonProfile person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        return true;
    }
    
     @Override
    public String toString() {
        return "Account{" + "username=" + username + ", person=" + person + '}';
    }
}
