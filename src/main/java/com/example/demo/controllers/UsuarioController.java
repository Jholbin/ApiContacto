package com.example.demo.controllers;

import java.util.List;

import com.example.demo.models.UsuarioModel;
import com.example.demo.services.UsuarioService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping("/lista")
	public List<UsuarioModel> index() {
		return usuarioService.listarTodos();
	}

    @PostMapping("/registrar")
	public ResponseEntity<UsuarioModel> registrar(@RequestBody UsuarioModel bean) {
    	UsuarioModel obj=usuarioService.registrar(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}
    
    @PutMapping("/actualizar")
	public ResponseEntity<UsuarioModel> actualizar(@RequestBody UsuarioModel bean) {
		UsuarioModel obj=usuarioService.actualizarUsuario(bean);
		return new ResponseEntity<>(obj,HttpStatus.CREATED);
	}


    @DeleteMapping("/eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") Integer cod){
		usuarioService.eliminarPorID(cod);		
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}