package com.example.noronapp.data.mappers;

import com.example.noronapp.data.request.VendorRequest;
import com.example.noronapp.data.response.VendorResponse;
import noronapp.jooq.data.tables.pojos.Vendor;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VendorMapper {
    Vendor requestToVendor(VendorRequest vendorRequest);

    VendorResponse vendorToResponse(Vendor vendor);

    List<VendorResponse> vendorsToResponses(List<Vendor> vendors);
}
