package com.example.relatoriocar.controller;


import com.example.relatoriocar.entity.Car;
import com.example.relatoriocar.exception.ResourceNotFoundException;
import com.example.relatoriocar.services.CarService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/car")
public class CarController {
    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping
    public Car criar(@RequestBody Car car){
        return service.criar(car);
    }
    @GetMapping
    public List<Car> listar() {
        return service.listar();
    }

    @GetMapping("/paginado")
    public Page<Car> listarPaginado(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction
    ) {
        return service.listarPaginado(page, size, sortBy, direction);
    }

    @GetMapping("/{id}")
    public Car buscarPorId(@PathVariable Long id) throws ResourceNotFoundException {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Car atualizar(@PathVariable Long id, @RequestBody Car car) throws ResourceNotFoundException {
        return service.atualizar(id, car);
    }

    @DeleteMapping("/{id}")
    public Car delete(@PathVariable Long id) throws ResourceNotFoundException {
        return service.delete(id);
    }


}
