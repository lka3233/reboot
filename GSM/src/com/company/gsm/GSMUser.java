package com.company.gsm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GSMUser {
    private String name;
    private String department;
    private String position;

    public GSMUser(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            System.out.println("Ваше ФИО:");
            name = br.readLine();
            System.out.println("Ваш отдел:");
            department = br.readLine();
            System.out.println("Ваша должность:");
            position = br.readLine();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getPosition() {
        return position;
    }
}
