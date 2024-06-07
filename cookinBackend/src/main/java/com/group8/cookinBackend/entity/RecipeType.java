package com.group8.cookinBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipetypes")
public class RecipeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recipetypeid;

    @Column(name = "recipetypedesc", nullable = false)
    private String recipetypedesc;

    // Getter and Setter for recipetypeid
    public int getRecipetypeid() {
        return recipetypeid;
    }

    public void setRecipetypeid(int recipetypeid) {
        this.recipetypeid = recipetypeid;
    }

    // Getter and Setter for recipetypedesc
    public String getRecipetypedesc() {
        return recipetypedesc;
    }

    public void setRecipetypedesc(String recipetypedesc) {
        this.recipetypedesc = recipetypedesc;
    }
}
