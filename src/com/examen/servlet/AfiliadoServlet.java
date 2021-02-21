package com.examen.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examen.bean.Afiliado;
import com.examen.bean.Funcionario;
import com.examen.service.AfiliadoServiceImpl;
import com.examen.service.FuncionarioServiceImpl;
import com.examen.service.IAfiliadoService;
import com.examen.service.IFuncionarioService;

@WebServlet("/AfiliadoServlet")
public class AfiliadoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IAfiliadoService serviceAfiliado;
	private IFuncionarioService serviceFuncionario;
	
	public AfiliadoServlet() {
		serviceAfiliado = new AfiliadoServiceImpl();
		serviceFuncionario = new FuncionarioServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String accion = request.getParameter("accion");
		System.out.println("action :"+accion);
		String idAfiliado = request.getParameter("idAfiliado");
		System.out.println("idAfiliado :"+idAfiliado);
		switch (accion) {
		case "listar":
			listarAfiliado(request, response);
			break;

		case "nuevo":
			mostrarAfiliadoForm(request, response, 0);
			break;
			
		case "editar":
			mostrarAfiliadoForm(request, response, Integer.parseInt(idAfiliado));
			break;	
			
		case "guardar":
			guardarAfiliado(request, response);
			break;	
		}
	}

	



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	// GOOOO
	private void listarAfiliado(HttpServletRequest request, HttpServletResponse response) {

		List<Afiliado> afiliadoList = serviceAfiliado.listar();
		RequestDispatcher dispatcher = request.getRequestDispatcher("afiliado_list.jsp");
		try {
			request.setAttribute("afiliadoList", afiliadoList);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

	private void mostrarAfiliadoForm(HttpServletRequest request, HttpServletResponse response, int idAfiliado ) {
try {
	System.out.println("MostrarAfiliadoForm"+ idAfiliado);
		RequestDispatcher dispatcher= request.getRequestDispatcher("afiliado_form.jsp");
		
		//COMBO
		List<Funcionario>funcionarioList=serviceFuncionario.listar();
		System.out.println("funcionarioList :"+ funcionarioList.size());
		request.setAttribute("funcionarioList", funcionarioList);
		
		
		Afiliado afiliadoForm= new Afiliado();
		afiliadoForm.setIdAfiliado(idAfiliado);
		
		if(idAfiliado== 0) {
			afiliadoForm= new Afiliado();
			afiliadoForm.setCliente("sa");
			afiliadoForm.setPago(00);
		}
		else {
			afiliadoForm= serviceAfiliado.buscar(afiliadoForm);
		}
		
			request.setAttribute("afiliadoForm", afiliadoForm);
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}



	private void guardarAfiliado(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("GuardarAfiliado");
		
		Afiliado afiliado= new Afiliado();
		afiliado.setIdAfiliado(Integer.parseInt(request.getParameter("txtIdAfiliado")));
		afiliado.setFuncionario(Integer.parseInt(request.getParameter("cboIdFunci")));
		afiliado.setCliente(request.getParameter("txtCliente"));
		afiliado.setPago(Double.parseDouble(request.getParameter("txtPago")));
		afiliado.setEstado(Integer.parseInt(request.getParameter("cboEstado")));
		
		int prueba=serviceAfiliado.guardar(afiliado);
		System.out.println("GuardarAfiliado :"+prueba);
		if(prueba>0) {
			listarAfiliado(request, response);
		}
		
	}




}
