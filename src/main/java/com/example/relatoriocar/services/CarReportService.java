package com.example.relatoriocar.services;

import com.example.relatoriocar.entity.Car;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Service
public class CarReportService {

    private final CarService carService;
    private final ReportCreateService reportCreateService;

    public CarReportService(CarService carService, ReportCreateService reportCreateService) {
        this.carService = carService;
        this.reportCreateService = reportCreateService;
    }

    public File generatedReportTxt() throws IOException {
        List<Car> cars = carService.listar();
        File file = reportCreateService.createService(
                "Relatorio_Carros", ".txt"
        );

        try(FileWriter writer = new FileWriter(file)){
            for(Car car : cars){
                writer.write(

                        car.getModelo() + " | " +
                        car.getMarca() + " | " +
                                car.getAno() + " | " +
                                car.getAno() + " | " +
                                car.getPreco() + " | " +
                                car.getCor() + "\n"
                );
            }
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever relatorio", e);
        }

        return file;
    }

}
