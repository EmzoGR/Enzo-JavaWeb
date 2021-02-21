package com.examen.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.examen.bean.Afiliado;
import com.examen.util.JDBCUtil;

public class AfiliadoDaoImpl implements IDaoAfiliado {

	public JDBCUtil bd;

	public AfiliadoDaoImpl() {
		this.bd = new JDBCUtil();
	}

	// inicializando
	ResultSet rs;
	// end

	@Override
	public List<Afiliado> list() {
		List<Afiliado> temporal = null;
		String sql = "select t.IDAFILIADO,f.ID_FUNCIONARIO ,f.NOMBRE, t.CLIENTE,t.PAGO,t.estado from TAFILIADO t inner join TFUNCIONARIO f on t.ID_FUNCIONARIO= f.ID_FUNCIONARIO";
		System.out.println("sql :" + sql);
		try {
		Connection	con = bd.getConexion();
			PreparedStatement st = con.prepareStatement(sql);
			temporal = new ArrayList<Afiliado>();
			rs = st.executeQuery();
			while (rs.next()) {
				Afiliado a = new Afiliado();
				a.setIdAfiliado(rs.getInt("IDAFILIADO"));
				a.setFuncionario(rs.getInt("ID_FUNCIONARIO"));
				a.setNomFun(rs.getString("NOMBRE"));
				a.setCliente(rs.getString("CLIENTE"));
				a.setPago(rs.getDouble("PAGO"));
				a.setEstado(rs.getInt("ESTADO"));
				temporal.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temporal;
	}
	

	@Override
	public int save(Afiliado afiliado) {
		int temporal = 0;
		String sql = "insert into TAFILIADO (ID_FUNCIONARIO,CLIENTE,PAGO,ESTADO) values " + "("+afiliado.getFuncionario()+","
				                        + "'" + afiliado.getCliente() +"'," 
				                         + afiliado.getPago() +"," 
				                        + afiliado.getEstado()+")";
		System.out.println("sql :" + sql);
		try {
			Connection con = bd.getConexion();
			PreparedStatement st = con.prepareStatement(sql);
			temporal = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temporal;
	}

	@Override
	public int update(Afiliado afiliado) {
		int temporal = 0;
		String sql = "update TAFILIADO set " + "ID_FUNCIONARIO=" + afiliado.getFuncionario() + "," + "CLIENTE='"
				+ afiliado.getCliente() + "'," + "PAGO=" + afiliado.getPago() + "," + "Estado=" + afiliado.getEstado()
				+ " where IDAFILIADO=" + afiliado.getIdAfiliado();
		System.out.println("sql :" + sql);

		try {
			Connection con = bd.getConexion();
			PreparedStatement st = con.prepareStatement(sql);
			temporal = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temporal;
	}

	@Override
	public Afiliado find(Afiliado afiliado) {
		Afiliado temporal = null;
		String sql = "select t.IDAFILIADO,f.ID_FUNCIONARIO ,f.NOMBRE, t.CLIENTE,t.PAGO,t.estado from TAFILIADO t inner join "
				+ "TFUNCIONARIO f on t.ID_FUNCIONARIO= f.ID_FUNCIONARIO"
				+" where t.IDAFILIADO="+ afiliado.getIdAfiliado();
		System.out.println("sql :" + sql);
		try {
			Connection con = bd.getConexion();
			PreparedStatement st = con.prepareStatement(sql);
			rs = st.executeQuery();
			temporal = new Afiliado();
			while (rs.next()) {
				temporal.setIdAfiliado(rs.getInt("IDAFILIADO"));
				temporal.setFuncionario(rs.getInt("ID_FUNCIONARIO"));
				temporal.setNomFun(rs.getString("NOMBRE"));
				temporal.setCliente(rs.getString("CLIENTE"));
				temporal.setPago(rs.getDouble("PAGO"));
				temporal.setEstado(rs.getInt("ESTADO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temporal;
	}

}
