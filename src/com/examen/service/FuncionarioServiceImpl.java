package com.examen.service;

import java.util.List;

import com.examen.bean.Funcionario;
import com.examen.dao.FuncionarioDaoImpl;
import com.examen.dao.IDaoFuncionario;

public class FuncionarioServiceImpl implements IFuncionarioService{

	public IDaoFuncionario dao;
	public FuncionarioServiceImpl() {
		dao= new FuncionarioDaoImpl();
	}
	
	@Override
	public List<Funcionario> listar() {
		return dao.list();
	}
	
	

}
