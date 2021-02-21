package com.examen.service;

import java.util.List;
import com.examen.bean.Afiliado;
import com.examen.dao.AfiliadoDaoImpl;
import com.examen.dao.IDaoAfiliado;

public class AfiliadoServiceImpl implements IAfiliadoService{
	
	public IDaoAfiliado dao;
	public AfiliadoServiceImpl() {
		dao= new AfiliadoDaoImpl();
	}
	
	@Override
	public List<Afiliado> listar() {
		return dao.list();
	}

	@Override
	public int guardar(Afiliado afiliado) {
		
		if(dao.find(afiliado).getIdAfiliado()==0) {
			return dao.save(afiliado);
		}
		else {return dao.update(afiliado);
		}
		
	}

	@Override
	public Afiliado buscar(Afiliado afiliado) {
		return dao.find(afiliado);
	}
	
	
	
	

}
