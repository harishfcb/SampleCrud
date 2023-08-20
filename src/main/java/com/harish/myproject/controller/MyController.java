package com.harish.myproject.controller;

import com.harish.myproject.model.Personalinfo;
import com.harish.myproject.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;



@RestController
@Controller
@RequestMapping("/Main")
public  class MyController {


      @Autowired(required = true)
      private MyService myService;


      @GetMapping("/listAllInfo")
      public Flux<Personalinfo>listAllInfo(){
          return myService.listAllInfo();

      }

      @PostMapping("/create")
      public Mono<Personalinfo> create(@RequestBody Personalinfo personalinfo){
            return myService.create(personalinfo);
      }

      @PutMapping("/update/{id}")
      public  Mono<ResponseEntity<Personalinfo>> updateById(@PathVariable String id, @RequestBody Personalinfo Personal){
            return myService.updateById(id,Personal)
                    .map(ResponseEntity::ok)
                    .defaultIfEmpty(ResponseEntity.notFound().build());
      }

      @DeleteMapping("/delete/{id}")
      public Mono<ResponseEntity<Void>> deleteById(@RequestParam String id){
            return myService.deleteById(id)
                    .map(ResponseEntity::ok);

      }
      @GetMapping("/get/{id}")
      public Mono<Personalinfo> getById(@PathVariable String id){
          return myService.getById(id);
      }

      @PostMapping("/createbulk")
      public  Flux<Personalinfo> createBUlkPersonalInfo(@RequestBody List<Personalinfo> personalinfo){
            return myService.createBulkInfo(personalinfo);
      }

      @DeleteMapping("/deleteallinfo")
      public Mono<ResponseEntity<Void>> deleteALl(){
            return myService.deleteAll()
                    .map(ResponseEntity::ok);

      }


}