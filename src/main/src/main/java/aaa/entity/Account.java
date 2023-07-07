package aaa.entity;

import java.sql.Date;

public class Account {

    private Integer id;
    private String name;
    private Date date_registration;

    public Account(String name, Date date_registration) {
        this.name = name;
        this.date_registration = date_registration;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_registration=" + date_registration +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_registration() {
        return date_registration;
    }

    public void setDate_registration(Date date_registration) {
        this.date_registration = date_registration;
    }

    public Account(Integer id, String name, Date date_registration) {
        this.id = id;
        this.name = name;
        this.date_registration = date_registration;
    }
}
