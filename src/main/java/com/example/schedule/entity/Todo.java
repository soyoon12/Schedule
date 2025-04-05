package com.example.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "Todo")
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition= "longtext")
    private String contents;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User username;

    public Todo( String title, String contents ) {
        this.title = title;
        this.contents = contents;

    }

    public Todo() {

    }


    public void setUser(User user) {
        this.username = user;
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}