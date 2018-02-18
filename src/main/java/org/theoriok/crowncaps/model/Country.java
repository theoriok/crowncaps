package org.theoriok.crowncaps.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;

    @Column(unique = true)
    private String code;

    private String name;


    private Country() {
    }

    public Country(String code, String name) {
        super();
        this.code = code;
        this.name = name;
    }

    public Integer getSid() {
        return this.sid;
    }


    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Country)) {
            return false;
        }
        Country country = (Country) obj;
        return Objects.equals(getSid(), country.getSid())
                && Objects.equals(getCode(), country.getCode())
                && Objects.equals(getName(), country.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid(), getCode(), getName());
    }
}
