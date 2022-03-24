/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.implement.service;

import edu.mx.tecnm.oaxaca.examen1.model.AlumnoModel;
import edu.mx.tecnm.oaxaca.examen1.repository.AlumnoRepository;
import edu.mx.tecnm.oaxaca.examen1.service.AlumnoService;
import edu.mx.tecnm.oaxaca.examen1.utils.FunctionGenerateICA;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alfredo
 */
@Service
public class AlumnoImplementService implements AlumnoService{

    @Autowired
    private AlumnoRepository alumnoRepository;
    
    @Override
    public void createAlumno(AlumnoModel alumno) {
        alumnoRepository.save(alumno);
    }

    @Override
    public List getAlumnos() {
        return alumnoRepository.findAll();
    }

    @Override
    public AlumnoModel getAlumno(String numControl) {
        return alumnoRepository.findByNumControl(numControl);
    }

    @Override
    public void updateAlumno(AlumnoModel alumno, String numControl) {
        alumno.setNumControl(numControl);
        alumnoRepository.save(alumno);
    }

    @Override
    public void deleteAlumno(String numControl) {
        alumnoRepository.deleteById(numControl);
    }
    
}
