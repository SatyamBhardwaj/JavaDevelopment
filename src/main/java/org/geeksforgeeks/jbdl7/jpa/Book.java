package org.geeksforgeeks.jbdl7.jpa;
import org.hibernate.annotations.CreationTimestamp;


import java.util.Date;

import javax.persistence.*;

@Entity
@IdClass(BookPrimaryKey.class)
public class Book {

    @Id
    private String name;

    @Id
    private String authorName;

    @Column(name = "price")
    private int cost;


    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TimeStamp")
    private Date createDate;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

}
