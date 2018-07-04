package books.biz;

import static common.DBTemplate.getConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import books.dao.AddWishDAO;
import books.dao.ToxicDAO;
import books.entity.ToxicDTO;
import books.entity.WishlistDTO;

public class AddWishBiz {
	
 	
	 public ArrayList<WishlistDTO> callAddWish(String gds_cd1, int gds_qty1) {
		 Connection con = getConnection();
		 AddWishDAO dao = new AddWishDAO();
		 ArrayList<WishlistDTO> wslist = new ArrayList<WishlistDTO>();

		 try {
			 wslist = dao.addWishProduct(con, gds_cd1, gds_qty1);
			 
			 /*CALL SP_CM_WTHR_M_RCV_SAVE ('R','EAI', #{result, mode=OUT, jdbcType=NUMERIC}, #{result2, mode=OUT, jdbcType=VARCHAR})*/
			 System.out.println("##### wslist : "+wslist.toString());
			con.close();
		 } catch (SQLException e) {
			e.printStackTrace();
		 }
		 return wslist;
	 }	
}

