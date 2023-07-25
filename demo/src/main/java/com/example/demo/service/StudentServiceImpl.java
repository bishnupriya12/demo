package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.utility.CommonUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    CommonUtility commonUtility;

    @Override
    public boolean entityValidation(Student student) {
        boolean isSectionValid = false;
        boolean isGenderValid= false;
        boolean isAgeValid= false;
        boolean isEntityValidation = false;
        int age =commonUtility.calculateAge(student.getDob());
        if(student.getGender().toLowerCase()== "male" || student.getGender().toLowerCase()=="female");
            isGenderValid = true;
        if(student.getSection()=='A' ||  student.getSection()=='B' || student.getSection()=='C')
            isSectionValid = true;
        if(age>15 && age<=20)
            isAgeValid = true;
        if(isAgeValid==true  && isGenderValid==true && isSectionValid== true)
            isEntityValidation= true;
        else
            isEntityValidation = false;
        /*System.out.println("Age :"+age);
        System.out.println("Section :"+student.getSection());
        System.out.println("isAgeValid :"+isAgeValid);
        System.out.println("isGenderValid :"+isGenderValid);
        System.out.println("isSectionValid :"+isSectionValid);

        System.out.println("isEntityValidation :"+isEntityValidation);*/
        return isEntityValidation;
    }

}
