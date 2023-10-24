package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.UsuarioModel;
import com.example.demo.repositories.UsuarioRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;
    
    public List<UsuarioModel> listarTodos(){
		return (List<UsuarioModel>) usuarioRepository.findAll();
	}

    public UsuarioModel registrar(UsuarioModel m) {
		return usuarioRepository.save(m);
	}

    public UsuarioModel buscarPorID(Integer cod) {
		return usuarioRepository.findById(cod).orElse(null);
	}
    public UsuarioModel actualizarUsuario(UsuarioModel usuario){
        return usuarioRepository.save(usuario);
    }
    

    public void eliminarPorID(Integer cod) {
		usuarioRepository.deleteById(cod);
	}


    
}