package com.WEATHER.REST_API1.Controller;

import com.WEATHER.REST_API1.service.IGreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Genesys")
public class RESTAPI1
{
    @Autowired
    private IGreetService service;

    public RESTAPI1 ()
    {
        System.out.println ("http://localhost:8080/Genesys/greeting");
    }

    @GetMapping("greeting")
    public ResponseEntity<String> RE()
    {
        String body = service.generateWishes ();
        return new ResponseEntity<> (body, HttpStatus.OK);
    }
}

