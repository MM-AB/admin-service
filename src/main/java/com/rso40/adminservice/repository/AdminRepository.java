package com.rso40.adminservice.repository;

import com.rso40.adminservice.model.Admin;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdminRepository extends MongoRepository<Admin, String> {

}
