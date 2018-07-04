package books.biz;

import static common.DBTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import books.dao.WishlistDAO;
import books.entity.WishlistDTO;

public class WishlistBiz {

	public ArrayList<WishlistDTO> selectWishlistAll(String temp_sql) {
		Connection con = getConnection();
		 WishlistDAO dao = new WishlistDAO();
		 ArrayList<WishlistDTO> wllist = new ArrayList<WishlistDTO>();

		 wllist = dao.selectWishlistAll(con, temp_sql);
		 System.out.println("##### wllist : "+wllist.toString());
		 try {
			con.close();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 return wllist;
	}	
}

