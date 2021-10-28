package com.ttn.project.ecommerce.repos;

import com.ttn.project.ecommerce.entities.Seller;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SellerRepository extends PagingAndSortingRepository<Seller,Long> {

    Seller findByCompanyName(String companyName);
    Seller findByGst(String gst);
}
