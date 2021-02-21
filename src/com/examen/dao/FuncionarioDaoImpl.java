package com.examen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen.bean.Funcionario;
import com.examen.util.JDBCUtil;

public class FuncionarioDaoImpl implements IDaoFuncionario{

	public JDBCUtil bd;
	public FuncionarioDaoImpl() {
		this.bd= new JDBCUtil();
	}
	
	@Override
	public List<Funcionario> list() {
		List<Funcionario> temporal= null;
		
		String sql="select*from TFUNCIONARIO";
		System.out.println("sql :"+sql);
		try {
			Connection con= bd.getConexion();
			PreparedStatement st= con.prepareStatement(sql);
			temporal= new ArrayList<Funcionario>();
			ResultSet rs= st.executeQuery();
			while (rs.next()) {
				Funcionario f= new Funcionario();
				f.setID_FUNCIONARIO(rs.getInt("ID_FUNCIONARIO"));
				f.setNombre(rs.getString("Nombre"));
				temporal.add(f);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temporal;
	}
	
	

}
