package com.lambdaschool.zoos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "telephones")
public class Telephone extends Auditable {

    /**
     * The primary key (long) of the telephones table
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long phoneid;

    /**
     * Phone type (String) for this zoo. Cannot be nullable.
     */
    @Column(nullable = false)
    private String phonetype;

    /**
     * Phone number (String) for this zoo. Cannot be nullable.
     */
    @Column(nullable = false)
    private String phonenumber;

    @ManyToOne
    @JoinColumn(name = "zooid")
    @JsonIgnoreProperties(value = "telephones",
            allowSetters = true)
    private Zoo zoo;

    public Telephone() {
    }

    public Telephone(long phoneid, String phonetype, String phonenumber) {
        this.phoneid = phoneid;
        this.phonetype = phonetype;
        this.phonenumber = phonenumber;
    }

    public long getPhoneid() {
        return phoneid;
    }

    public void setPhoneid(long phoneid) {
        this.phoneid = phoneid;
    }

    public String getPhonetype() {
        return phonetype;
    }

    public void setPhonetype(String phonetype) {
        this.phonetype = phonetype;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
