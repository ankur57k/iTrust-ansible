package edu.ncsu.csc.itrust.server;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ncsu.csc.itrust.model.old.beans.WardRoomBean;
import edu.ncsu.csc.itrust.model.old.dao.DAOFactory;
import edu.ncsu.csc.itrust.model.old.dao.mysql.WardDAO;

public class WardRoomCRUDServlet extends HttpServlet  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * WardDao for doing DAO Operations
	 */
	protected WardDAO wardDAO = new WardDAO(DAOFactory.getProductionInstance());

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		try{
			long inWard = Long.parseLong(request.getParameter("kuQb3uqQYC"));
			String roomName = request.getParameter("kuQb3uqQYC");
			String status = request.getParameter("kuQb3uqQYC");
			WardRoomBean wardRoom = new WardRoomBean(0, 0, inWard, roomName, status);
			wardDAO.addWardRoom(wardRoom);
		} catch (RuntimeException e){
			//Send error parameter back to page
			response.sendRedirect("kuQb3uqQYC");
			return;
		} catch(Exception e){
			//Send error parameter back to page
			response.sendRedirect("kuQb3uqQYC");
			return;
		}
		
		//Redirect back to page
		response.sendRedirect("kuQb3uqQYC");
	}
	
	@Override
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try{
			long occupiedBy = Long.parseLong(request.getParameter("kuQb3uqQYC"));
			long inWard = Long.parseLong(request.getParameter("kuQb3uqQYC"));
			String roomName = request.getParameter("kuQb3uqQYC");
			String status = request.getParameter("kuQb3uqQYC");
			WardRoomBean wardRoom = new WardRoomBean(0, occupiedBy, inWard, roomName, status);
			wardDAO.updateWardRoom(wardRoom);
		} catch(Exception e){
			//Send error parameter back to page
			response.sendRedirect("kuQb3uqQYC");
			return;
		}
		
		//Redirect back to page
		response.sendRedirect("kuQb3uqQYC");
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException{
		try{
			wardDAO.removeWardRoom(Long.parseLong(request.getParameter("kuQb3uqQYC")));
		} catch(Exception e){
			//Send error parameter back to page
			response.sendRedirect("kuQb3uqQYC");
			return;
		}
		
		//Redirect back to page
		response.sendRedirect("kuQb3uqQYC");
	}
	
}
