package com.Optimart.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "slug", nullable = false, unique = true)
    private String slug;

    @Column(name = "image")
    private String image;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "countInStock",nullable = false)
    private int countInStock;

    @Column(name = "description")
    private String description;

    @Column(name = "discount")
    private int discount;

    @Column(name = "discountStartDate")
    private Date discountStartDate;

    @Column(name = "discountEndDate")
    private Date discountEndDate;

    @Column(name = "sold")
    private int sold;

    @Column(name = "totalLikes")
    private int totalLikes =0;

    @Column(name =  "status")
    private int status = 0;

    @Column(name = "views")
    private int views = 0;

    @OneToMany(mappedBy = "product")
    private List<User> userList;

    @ManyToMany
    @JoinTable(
            name = "locationProduct",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "city_id")
    )
    private List<City> cityList;

    @ManyToMany(mappedBy = "likeProductList")
    private List<User> userLikedList;

    @ManyToMany(mappedBy = "viewedProductList")
    private List<User> userViewedList;

    @ManyToMany
    @JoinTable(
            name = "productTypes",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "productType_id")
    )
    private List<ProductType> productTypeList;

    @OneToMany(mappedBy = "product")
    private List<Review> reviewList;

    @OneToMany(mappedBy = "product")
    private List<Comment> commentList;
}