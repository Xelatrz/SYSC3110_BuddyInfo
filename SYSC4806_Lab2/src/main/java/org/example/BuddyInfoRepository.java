package org.example;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource()
public interface BuddyInfoRepository extends CrudRepository<BuddyInfo, Long> {
    List<BuddyInfo> findByPhoneNumber(String phoneNumber);
    List<BuddyInfo> findByName(String name);
    BuddyInfo findById(long id);
}

