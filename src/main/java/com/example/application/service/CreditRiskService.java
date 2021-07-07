package com.example.application.service;

import com.example.application.pojo.PredictionDTO;
import com.example.application.pojo.PredictionResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CreditRiskService {

    @Autowired
    RestTemplate restTemplate;

    private String backendUrl = System.getenv("BACKEND_URL");

    public CreditRiskService(){

    }

    public String getPrediction(PredictionDTO dto){
        try{
            PredictionResponse resp = restTemplate.postForObject(backendUrl, dto, PredictionResponse.class);
            return resp.getPrediction() + ":" + resp.getScore();
        }catch(Exception e){
            e.printStackTrace();
            return e.getMessage();
        }
        
    }
    
}
