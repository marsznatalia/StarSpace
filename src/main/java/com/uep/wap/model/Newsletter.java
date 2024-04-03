package com.uep.wap.model;

import javax.persistence.*;

@Entity
@Table(name="newsletters")
public class Newsletter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private long id;
    @Column(name ="title")
    private String title;
    //@Column(name ="news")
    //private List<News> news;
    public Newsletter(){

    }

}


