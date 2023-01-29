package com.user.service.userservice.entity;

import com.user.service.userservice.entity.rating.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @Column(name="ID")
    private String userId;
    @Column(name="NAME", length = 20)
    private String name;
    @Column(name="EMAIL")
    private String email;
    @Column(name="ABOUT")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
