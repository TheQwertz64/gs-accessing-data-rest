package com.example.storeService;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tvs", path = "tvs")
public interface recTVRepository extends PagingAndSortingRepository<RecTV, Long>, CrudRepository<RecTV,Long> {

	List<RecTV> findBysid(@Param("sid") long sid);

	RecTV findById(long id);


}
