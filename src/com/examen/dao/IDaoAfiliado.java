package com.examen.dao;

import java.util.List;

import com.examen.bean.Afiliado;

public interface IDaoAfiliado {
	
	List<Afiliado> list();

	int save(Afiliado afiliado);

	int update(Afiliado afiliado);

	Afiliado find(Afiliado afiliado);

}
