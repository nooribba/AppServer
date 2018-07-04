package books.biz;

import static common.DBTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import books.dao.ToxicDAO;
import books.entity.ToxicDTO;

public class ToxicBiz {
	
 	
	 public ArrayList<ToxicDTO> selectToxicAll(String tmp) {
		 Connection con = getConnection();
		 ToxicDAO dao = new ToxicDAO();
		 ArrayList<ToxicDTO> tslist = new ArrayList<ToxicDTO>();

		 tslist = dao.selectToxicAll(con,tmp);
		 System.out.println("##### tslist : "+tslist.toString());
		 try {
			con.close();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 return tslist;
	 }	
}

