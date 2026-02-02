package com.example.relatoriocar.services;

import com.example.relatoriocar.entity.Car;
import com.example.relatoriocar.exception.ResourceNotFoundException;
import com.example.relatoriocar.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository repository;

    public CarService(CarRepository repository){
        this.repository = repository;
    }

    public Car criar(Car car){
        return repository.save(car);
    }

    public List<Car> listar(){
        return repository.findAll();
    }

    public Car buscarPorId(Long id) throws ResourceNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado por ID: " + id));
    }

    public Car atualizar(Long id, Car car) throws ResourceNotFoundException {
        Car carExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado por ID: " + id));

        carExistente.setModelo(car.getModelo());
        carExistente.setMarca(car.getMarca());
        carExistente.setAno(car.getAno());
        carExistente.setCor(car.getCor());
        carExistente.setPreco(car.getPreco());
        carExistente.setQuilometragem(car.getQuilometragem());
        carExistente.setDisponibilidade(car.getDisponibilidade());

        return repository.save(carExistente);

    }

    public Car delete(Long id) throws ResourceNotFoundException{
        Car carExistente = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Carro não encontrado com ID: " + id));

        repository.delete(carExistente);
        return carExistente;
    }
}
