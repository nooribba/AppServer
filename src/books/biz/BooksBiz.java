package books.biz;

import static common.DBTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import books.dao.BookDAO;
import books.entity.BookDTO;

public class BooksBiz {
	
 	
	 public ArrayList<BookDTO> selectBsearch(String tmp) {
		 Connection con = getConnection();
		 BookDAO dao = new BookDAO();
		 ArrayList<BookDTO> blist = new ArrayList<BookDTO>();

		 blist = dao.bselect(con,tmp);
		 try {
			con.close();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 return blist;
	 }	
}

