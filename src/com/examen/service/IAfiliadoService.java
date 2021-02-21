package com.examen.service;

import java.util.List;

import com.examen.bean.Afiliado;

public interface IAfiliadoService {

	List<Afiliado> listar();

	int guardar(Afiliado afiliado);
	Afiliado buscar(Afiliado afiliado);

}
