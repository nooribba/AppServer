package books.dao;
 
import static common.DBTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import books.entity.BookDTO;

public class BookDAO {

	public ArrayList<BookDTO> bselect(Connection con, String tmp) {
		ArrayList<BookDTO> blist = new ArrayList<BookDTO>();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT * FROM BOOK WHERE btitle like ?";

			stmt = con.prepareStatement(sql);
			
			stmt.setString(1, "%" + tmp + "%");

			rs = stmt.executeQuery();
			
			while (rs.next()) {
				BookDTO dto = new BookDTO();
				dto.setBisbn(rs.getString("BISBN"));
				dto.setBtitle(rs.getString("BTITLE"));
				dto.setBdate(rs.getString("BDATE"));
				dto.setBpage(rs.getString("BPAGE"));
				dto.setBprice(rs.getInt("BPRICE"));				
				dto.setBauthor(rs.getString("BAUTHOR"));
				dto.setBtranslator(rs.getString("BTRANSLATOR"));
				dto.setBsupplement(rs.getString("BSUPPLEMENT"));
				dto.setBpublisher(rs.getString("BPUBLISHER"));
				dto.setBimgurl(rs.getString("BIMGURL"));
				//dto.setBimgbase64(rs.getString("BIMGBASE64"));				
				blist.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rs);
				close(stmt);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		return blist;
	}
}
