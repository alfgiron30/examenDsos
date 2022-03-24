/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.controller;

import edu.mx.tecnm.oaxaca.examen1.model.AlumnoModel;
import edu.mx.tecnm.oaxaca.examen1.service.AlumnoService;
import edu.mx.tecnm.oaxaca.examen1.utils.CustomResponse;
import edu.mx.tecnm.oaxaca.examen1.utils.FunctionGenerateICA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alfredo
 */
@RestController
@RequestMapping("/api/v1/ica")
public class AlumnoController {

    @Autowired
    AlumnoService alumnoService;


    @PostMapping("/")
    public CustomResponse createAlumno(@RequestBody AlumnoModel alumno) {
        CustomResponse customResponse = new CustomResponse();
        FunctionGenerateICA function = new FunctionGenerateICA();

        AlumnoModel aux = alumnoService.getAlumno(alumno.getNumControl());

        if (aux == null) {
            function.calcularIca(alumno.getCintura(), alumno.getAltura());
            function.determinarNivel(alumno.getGenero());
            customResponse.setData(function);

            alumnoService.createAlumno(alumno);
        } else {
            Double cintura = aux.getCintura();
            Double altura = aux.getAltura();
            
            if (cintura == null || altura == null) {
                customResponse.setData("No se cuenta con la información necesaria para realizar el calculo. ");
            } else {
                function.calcularIca(aux.getCintura(), aux.getAltura());
                function.determinarNivel(aux.getGenero());
                customResponse.setData(function);
            }
        }

        return customResponse;
    }

    @GetMapping("/")
    public CustomResponse getAlumnos() {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(alumnoService.getAlumnos());
        return customResponse;
    }

    @GetMapping("/{numControl}")
    public CustomResponse getAlumno(@PathVariable String numControl) {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setData(alumnoService.getAlumno(numControl));
        return customResponse;
    }

    @PutMapping("/{numControl}")
    public CustomResponse updateAlumno(@RequestBody AlumnoModel alumnoModel, @PathVariable String numControl) {
        CustomResponse customResponse = new CustomResponse();
        alumnoService.updateAlumno(alumnoModel, numControl);
        customResponse.setData(alumnoModel);
        return customResponse;
    }

    @DeleteMapping("/{numControl}")
    public CustomResponse deleteAlumno(@PathVariable String numControl) {
        CustomResponse customResponse = new CustomResponse();
        alumnoService.deleteAlumno(numControl);
        return customResponse;
    }
}
