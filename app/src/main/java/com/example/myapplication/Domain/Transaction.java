package com.example.myapplication.Domain;

public class Transaction {
    private int id;
    private String  Title;
    private String Details;
    private int AccountId;
    private float Sold;
    private String created_at;
    private String updated_at;

    public Transaction(int id, String title, String details, int accountId, float sold, String created_at, String updated_at) {
        this.id = id;
        this.Title = title;
        this.Details = details;
        this.AccountId = accountId;
        this.Sold = sold;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Transaction(String title, String details, float  sold) {
        this.Sold=sold;
        this.Title=title;
        this.Details=details;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getDetails() {
        return Details;
    }

    public void setDetails(String details) {
        this.Details = details;
    }

    public int getAccountId() {
        return AccountId;
    }

    public void setAccountId(int accountId) {
        this.AccountId = accountId;
    }

    public float getSold() {
        return Sold;
    }

    public void setSold(float sold) {
        this.Sold = sold;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
