package books.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import books.biz.WishlistBiz;
import books.entity.WishlistDTO;


@WebServlet("/wl")
public class WishlistSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WishlistSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<WishlistDTO> wlSearch = new ArrayList<WishlistDTO>();
		WishlistBiz biz = new WishlistBiz();
		String temp_sql = request.getParameter("user_id");
		System.out.println("##### userid : "+temp_sql);
		String key = request.getParameter("callback");
		wlSearch = biz.selectWishlistAll(temp_sql); 
 
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		JSONArray wishList = new JSONArray();			  
		for( WishlistDTO tmp : wlSearch) {
			JSONObject t = new JSONObject();
			t.put("user_id", tmp.getUser_id());
			t.put("pd_id", tmp.getPd_id());
			t.put("pd_name", tmp.getPd_name());
			t.put("pd_cnt", tmp.getPd_cnt());
			t.put("store_id", tmp.getStore_id());
			t.put("store_name", tmp.getStore_name());
			t.put("code_id", tmp.getCode_id());

			wishList.add(t);			
		}
		
		out.print(key + "(" + wishList.toJSONString()+ ")");
		System.out.println("결과 : " + key + "(" + wishList.toJSONString()+ ")");	
		out.flush();
		out.close();
	}	
}
