package com.vihari.learn.hibernate;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Account_Info")
public class Account  {
    @Id
    @Column(name= "account")
    private int account_id;

    public Account(){

    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
    }
}
