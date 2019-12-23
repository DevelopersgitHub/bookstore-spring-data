package com.senlainc.training.backend.repository;

import com.senlainc.training.backend.domain.Request;
import org.springframework.data.repository.CrudRepository;

public interface IRequestRepository extends CrudRepository<Request, Long> {

}
