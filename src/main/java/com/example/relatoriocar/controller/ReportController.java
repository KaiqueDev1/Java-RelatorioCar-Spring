package com.example.relatoriocar.controller;


import com.example.relatoriocar.services.CarReportService;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;

@CrossOrigin(
        origins = "*",
        exposedHeaders = "Content-Disposition"
)
@RestController
@RequestMapping("/relatorio")
public class ReportController {

    private final CarReportService carReportService;

    public ReportController(CarReportService carReportService){
        this.carReportService = carReportService;
    }

    @GetMapping("/carros/txt")
    public ResponseEntity<Resource> gerarRelatorioTxt() throws IOException{
        File file = carReportService.generatedReportTxt();
        Resource resource = new FileSystemResource(file);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=\"Relatorio_Carros.txt\"")
                .contentLength(file.length())
                .contentType(MediaType.TEXT_PLAIN)
                .body(resource);


    }


}
