/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package edu.mx.tecnm.oaxaca.examen1.service;

import edu.mx.tecnm.oaxaca.examen1.model.AlumnoModel;
import java.util.List;

/**
 *
 * @author Alfredo
 */
public interface AlumnoService {
    public void createAlumno(AlumnoModel alumno);
    public List getAlumnos();
    public AlumnoModel getAlumno(String numControl);
    public void updateAlumno(AlumnoModel alumno, String numControl);
    public void deleteAlumno(String numControl);
}
