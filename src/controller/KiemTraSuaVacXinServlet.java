package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.GetVacxinBO;
import model.BO.SuaVacxinBO;
import model.BO.ThemVacxinBO;
import model.Bean.Vacxin;

/**
 * Servlet implementation class KiemTraSuaVacXinServlet
 */
@WebServlet("/KiemTraSuaVacXinServlet")
public class KiemTraSuaVacXinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KiemTraSuaVacXinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String maVacxin = request.getParameter("maVacxin");
			String tenVacxin = request.getParameter("tenVacxin");
			int soMui = Integer.parseInt(request.getParameter("soMui"));
			String moTa = request.getParameter("moTa");
			double giaVacxin = Double.parseDouble(request.getParameter("giaVacxin"));
			String tenHangSX = request.getParameter("tenHangSX");
			if (SuaVacxinBO.suaVacxin(maVacxin, tenVacxin, soMui, moTa, giaVacxin, tenHangSX)) {
				List<Vacxin> vacxins = new ArrayList<Vacxin>();
				vacxins = GetVacxinBO.getVacxin();
				request.setAttribute("vacxins", vacxins);
				request.getRequestDispatcher("SuaVacXin.jsp").forward(request, response);
			} else {
				response.sendRedirect("SuaChiTietVacXin.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
