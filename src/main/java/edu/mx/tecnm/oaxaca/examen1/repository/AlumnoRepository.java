/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.repository;

import edu.mx.tecnm.oaxaca.examen1.model.AlumnoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alfredo
 */
@Repository
public interface AlumnoRepository extends JpaRepository<AlumnoModel, String>{
    
    public AlumnoModel findByNumControl(String numControl);
}
