package com.example.noronapp.data.response;

import com.example.noronapp.data.request.VendorRequest;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import noronapp.jooq.data.tables.pojos.Vendor;


@Data
@Accessors(chain = true)
public class ProductResponse {

    private int id;

    private String handle;

    private String product_title;

    private String product_type;

    private String product_description;

    private String short_description;

    private int originPrice;

    private int discount;

    private int finalPrice;

    private int originCoin;

    private int finalCoin;

    private int numBuy;

    private int numReview;

    private int rating;

    private VendorResponse vendor;

    private Long categoryId;

    private Integer numView;


}
