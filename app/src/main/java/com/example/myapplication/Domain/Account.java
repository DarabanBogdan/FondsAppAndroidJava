package com.example.myapplication.Domain;

public class Account {


    private int id=0;
    private String Name="";
    private float Sold=0;
    private int Debt=1;
    private String created_at="";
    private String updated_at="";
    private int UserId=0;

    public Account(int id, String name, int UserId, float sold, int debt, String created_at, String updated_at) {
        this.id = id;
        this.UserId=UserId;
        this.Name = name;
        this.Sold = sold;
        this.Debt = debt;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Account(int id, String name, float sold, int debt, String created_at, String updated_at) {
        this.id = id;
        this.Name = name;
        this.Sold = sold;
        this.Debt = debt;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    public Account(String name, float sold){
        this.Name=name;
        this.Sold=sold;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }


    public float getSold() {
        return Sold;
    }

    public void setSold(float sold) {
        this.Sold = sold;
    }

    public int isDebt() {
        return Debt;
    }

    public void setDebt(int debt) {
        this.Debt = debt;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }
}
