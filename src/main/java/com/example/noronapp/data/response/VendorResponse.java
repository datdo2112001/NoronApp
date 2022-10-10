package com.example.noronapp.data.response;

import lombok.Data;
import lombok.experimental.Accessors;
import noronapp.jooq.data.tables.pojos.Users;

@Data
@Accessors(chain = true)
public class VendorResponse {
    private Integer id;
    private Integer userId;
    private String  handle;
    private String  status;
    private String  description;
    private Integer followCount;
    private Integer itemCount;
    private Users user;
}
