package com.example.relatoriocar.services;

import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class ReportCreateService {
    public File createService(String prefix, String suffix){

        try{
            return File.createTempFile(prefix, suffix);
        } catch (IOException e){
            throw new RuntimeException("Erro ao criar arquivo", e);
        }
    }
}
