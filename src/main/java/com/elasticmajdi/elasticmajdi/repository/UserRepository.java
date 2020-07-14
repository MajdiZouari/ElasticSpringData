package com.elasticmajdi.elasticmajdi.repository;

import java.util.List;
import java.util.UUID;

import com.elasticmajdi.elasticmajdi.model.UserModel;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends ElasticsearchRepository<UserModel, UUID> {

    List<UserModel> findByFirstName(String name);
}
