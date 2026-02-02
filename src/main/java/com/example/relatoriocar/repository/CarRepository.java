package com.example.relatoriocar.repository;

import com.example.relatoriocar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
