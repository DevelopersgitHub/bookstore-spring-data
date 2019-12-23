package com.senlainc.training.backend.services;

import com.senlainc.training.backend.domain.Request;
import com.senlainc.training.backend.repository.IRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RequestServiceImpl {

    @Autowired
    private IRequestRepository requestRepository;

    public void save(Request request) {
        this.requestRepository.save(request);
    }

    public List<Request> findAll() {
        return (List<Request>) this.requestRepository.findAll();
    }

    public Request findById(Long id) {
        Request request = null;
        Optional<Request> optionalRequest = this.requestRepository.findById(id);
        if (optionalRequest.isPresent()) {
            request = optionalRequest.get();
        }
        return request;
    }

    public void deleteById(Long id) {
        this.requestRepository.deleteById(id);
    }

}
