package com.dockerworkshop.feedservice;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Data
@Entity
public class Post {

    @Id
    @GeneratedValue
    private UUID id;

    private String title;

    private UUID userId;

    private String text;
}
