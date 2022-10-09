package com.example.demo.dto;

public class HealthCheckDTO {
    
    private boolean status; 
    private String message; 

    public HealthCheckDTO(boolean status, String message){
        this.status =  status;
        this.message =  message;
    }

    public boolean getStatus(){ return this.status;}

    public String getMessage() { return this.message; }

    public String toString(){ return this.getMessage() + " " + this.getStatus() + " "; }

}
