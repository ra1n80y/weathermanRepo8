package com.WEATHER.REST_API1.service;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class GenerateWishesService implements IGreetService
{
   public String generateWishes()
   {
       LocalDateTime ldt = LocalDateTime.now ();
       int hour = ldt.getHour ();
       String body;

       if (hour<12)
           body="GOOD MORNING!";
       else if (hour<18)
           body="GOOD AFTERNOON!";
       else if (hour<21)
           body="GOOD EVENING!";
       else
           body="GOOD NIGHT!";

       return body;
   }
}
