package com.example.noronapp.data.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String handle;

    private String title;

    private String type;

    private String description;

    private String short_description;

    private int origin_price;

    private Integer discount;

    private Integer final_price;

    private Integer origin_coin;

    private Integer final_coin;

    private Integer num_buy;

    private Integer num_review;

    private Integer rating;

    private Long vendorId = null;

    private Long categoryId = null;

    private Date created_at;
}
