package org.theoriok.crowncaps.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Cap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sid;

    private Integer amount = 0;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();

    private String description;

    private String name;

    @ManyToOne
    private Country country;


    protected Cap() {
    }

    public Cap(Integer amount, String description, String name, Country country) {
        super();
        this.amount = amount;
        this.description = description;
        this.name = name;
        this.country = country;
    }

    public void addCap() {
        addCaps(1);
    }

    public void addCaps(int amount) {
        if (this.amount + amount >= 0) {
            this.amount += amount;
        } else {
            this.amount = 0;
        }
    }


    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<Category> getCategories() {
        return this.categories;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getSid() {
        return this.sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public void removeCap() {
        addCaps(-1);
    }

    public void addCategory(Category category) {
        categories.add(category);
    }

    public void removeCategories() {
        categories.clear();
    }

    @Override
    public String toString() {
        return this.country + ": " + this.name + " (" + amount + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Cap)) {
            return false;
        }
        Cap cap = (Cap) obj;
        return Objects.equals(getSid(), cap.getSid())
                && Objects.equals(getAmount(), cap.getAmount())
                && Objects.equals(getCategories(), cap.getCategories())
                && Objects.equals(getDescription(), cap.getDescription())
                && Objects.equals(getName(), cap.getName())
                && Objects.equals(getCountry(), cap.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSid(), getAmount(), getCategories(), getDescription(), getName(), getCountry());
    }
}