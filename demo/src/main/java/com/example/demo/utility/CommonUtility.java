package com.example.demo.utility;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Component
public class CommonUtility {
    public static int calculateAge(LocalDate dob)
    {
//creating an instance of the LocalDate class and invoking the now() method
//now() method obtains the current date from the system clock in the default time zone
        LocalDate curDate = LocalDate.now();
//calculates the amount of time between two dates and returns the years
        if ((dob != null) && (curDate != null))
        {
            return Period.between(dob, curDate).getYears();
        }
        else
        {
            return 0;
        }
    }
}
