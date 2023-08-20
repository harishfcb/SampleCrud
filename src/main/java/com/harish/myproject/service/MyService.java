package com.harish.myproject.service;

import com.harish.myproject.model.Personalinfo;
import com.harish.myproject.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MyService {

    @Autowired(required = true)
    private  MyRepository myRepository;
    public Flux<Personalinfo> listAllInfo() {
        return myRepository.findAll();
    }

    public Mono<Personalinfo> create(Personalinfo personalinfo) {
        return myRepository.save(personalinfo);
    }


    public Mono<Personalinfo> updateById(String id, Personalinfo personal) {
        return myRepository.findById(id)
                .flatMap(existingPersonal -> {
                    // Only update the fields if the corresponding fields in 'personal' are not null
                    if (personal.getFirstName() != null) {
                        existingPersonal.setFirstName(personal.getFirstName());
                    }
                    if (personal.getLastName() != null) {
                        existingPersonal.setLastName(personal.getLastName());
                    }
                    if (personal.getPhoneNumber() != null) {
                        existingPersonal.setPhoneNumber(personal.getPhoneNumber());
                    }
                    if (personal.getAge() != null) {
                        existingPersonal.setAge(personal.getAge());
                    }

                    return myRepository.save(existingPersonal);
                });


    }


    public Mono<Void> deleteById(String id) {
        return myRepository.deleteById(id);
    }

    public Mono<Personalinfo> getById(String id) {
        return myRepository.findById(id);
    }


    public Flux<Personalinfo> createBulkInfo(List<Personalinfo> personalinfo) {
        return myRepository.saveAll(personalinfo);
    }


    public Mono<Void> deleteAll() {
        return myRepository.deleteAll();
    }
}
