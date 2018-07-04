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

import books.biz.BooksBiz;
import books.entity.BookDTO;


/**
 * Servlet implementation class BookSearchServletBasic
 */
@WebServlet("/bs")
public class BookSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// DTO를 생성해서 입력받은 data를 setting
		request.setCharacterEncoding("UTF-8");
		ArrayList<BookDTO> bsearch = new ArrayList<BookDTO>();
		BooksBiz biz = new BooksBiz();
		String temp_sql = request.getParameter("btitle");
		String key = request.getParameter("callback");
		bsearch = biz.selectBsearch(temp_sql); 
 
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		JSONArray book = new JSONArray();			  
		for( BookDTO tmp : bsearch) {
			JSONObject t = new JSONObject();
			t.put("bisbn",tmp.getBisbn());			
			t.put("btitle",tmp.getBtitle());
			t.put("bdate",tmp.getBdate());
			t.put("bpage",tmp.getBpage());
			t.put("bprice",tmp.getBprice());			
			t.put("bauthor",tmp.getBauthor());
			t.put("btranslator",tmp.getBtranslator());
			t.put("bsupplement",tmp.getBsupplement());
			t.put("bpublisher",tmp.getBpublisher());
			t.put("bimgurl",tmp.getBimgurl());
			t.put("bimgbase64",tmp.getBimgbase64());			
			book.add(t);			
		}
		
		out.print(key + "(" + book.toJSONString()+ ")");
		System.out.println("결과 : " + key + "(" + book.toJSONString()+ ")");	
		out.flush();
		out.close();
	}	
}
