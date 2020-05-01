/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package person;

/**
 *
 * @author tanaw
 */
public class PersonProfile {
    private String name;
    private String address;
    private String tel;

    public PersonProfile(PersonProfile person) {
        this.name= person.name;
        this.address = person.address;
        this.tel = person.tel;
    }

    public PersonProfile(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    @Override
    public String toString() {
        StringBuilder profile = new StringBuilder();
        profile.append(" Name : "+ name +"\t");
        profile.append(" Address :"+address+ "\t");
        profile.append(" Tel. :"+tel+ "\t");
        
        return profile.toString();
    }
    
    
}
