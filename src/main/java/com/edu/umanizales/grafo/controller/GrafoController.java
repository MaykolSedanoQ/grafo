/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.umanizales.grafo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.edu.umanizales.grafo.domain.model.Empleado;
import com.edu.umanizales.grafo.domain.model.dto.RespuestasDto;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author mayko
 */

@RestController
@RequestMapping(path="grafo")
@Validated
public class GrafoController {
    
    
    
    List<Empleado> listado = new ArrayList<>();
    public  GrafoController (){
        
        listado.add(new Empleado("Maykoll", 1000000));
        listado.add(new Empleado("Sebastian", 2000000));
        listado.add(new Empleado("Marlon", 3000000));
        listado.add(new Empleado("Camilo", 5000000));
        listado.add(new Empleado("Carlos", 8000000));
        listado.add(new Empleado("Samuel", 5000000));
        listado.add(new Empleado("Mario", 5000000));
        listado.add(new Empleado("Mateo", 5000000));
    }
    //metodoget get que recibe dos parametros
//    @GetMapping("/{param1}/{param2}")//entra almohadillas se hacen los parametros
//    
//    public String getRespuestaApi(@PathVariable("param1") String param1, 
//            @PathVariable("param2") String param2){//asi se llaman los parametros
//        
//        return param1 + " " + param2;
//    }
    
    
    @PostMapping
    public RespuestasDto calcularSalario (@RequestBody Empleado empleado){
        
        empleado.calcularSalario(10, 15000);
        RespuestasDto resp= new RespuestasDto(200, "Operacion Exitosa",empleado);
        return resp;
    }
    
    @GetMapping
    public List<Empleado> obtenerEmpleado(){
        
        return listado;
        
    }
   
   @GetMapping("/{salarioUno}/{salarioDos}")
   public RespuestasDto getEmpleadosxRangoSalarial(@PathVariable("salarioUno") double salarioUno,
   @PathVariable("salarioDos")double salarioDos){
    
       if (salarioUno >= salarioDos) {
           
           return  new RespuestasDto(500, "El salario uno debe ser menor" + "al salario dos", null);
       }
       
       List<Empleado> listaTemp= new ArrayList<>();
       
       for(Empleado emp: listado){
           if (emp.getSalario()>= salarioUno && emp.getSalario()<= salarioDos){
               listaTemp.add(emp);
           }
       }
    
    
        return new RespuestasDto(200, "Operacion Exitosa", listaTemp);
}
   
   @GetMapping("/{cadena}")
   public RespuestasDto getRespuestaxNombreEmpleado(@PathVariable("cadena") String cadena){
      
       List<Empleado> listaTemp= new ArrayList<>();
       
       for(Empleado emp: listado){
           if (emp.getNombre().toLowerCase().contains(cadena.toLowerCase())) {
               listaTemp.add(emp);
              
           }
           
       }
     
      return new RespuestasDto(200, "Operacion Exitosa", listaTemp);
       
        
       
   }

   
}
