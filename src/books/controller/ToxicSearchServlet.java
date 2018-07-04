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

import books.biz.ToxicBiz;
import books.entity.ToxicDTO;


@WebServlet("/ts")
public class ToxicSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToxicSearchServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ArrayList<ToxicDTO> tsSearch = new ArrayList<ToxicDTO>();
		ToxicBiz biz = new ToxicBiz();
		String temp_sql = request.getParameter("chem_name_kor");
		System.out.println("##### chem_name_kor : "+temp_sql);
		String key = request.getParameter("callback");
		tsSearch = biz.selectToxicAll(temp_sql); 
 
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();

		JSONArray toxic = new JSONArray();			  
		for( ToxicDTO tmp : tsSearch) {
			JSONObject t = new JSONObject();
			t.put("absor", tmp.getAbsor());
			t.put("cas_no", tmp.getCas_no());
			t.put("category_name", tmp.getCategory_name());
			t.put("chem_id", tmp.getChem_id());
			t.put("chem_name_eng", tmp.getChem_name_eng());
			t.put("chem_name_kor", tmp.getChem_name_kor());
			t.put("derma_tox", tmp.getDerma_tox());
			t.put("distribu", tmp.getDistribu());
			t.put("dosage", tmp.getDosage());
			t.put("elimina", tmp.getElimina());
			t.put("end_points", tmp.getEnd_points());
			t.put("kin_meta_info", tmp.getKin_meta_info());
			t.put("mecha", tmp.getMecha());
			t.put("metabol", tmp.getMetabol());
			t.put("pdf_url", tmp.getPdf_url());
			t.put("refer", tmp.getRefer());
			t.put("route", tmp.getRoute());
			t.put("species", tmp.getSpecies());
			t.put("total_count", tmp.getTotal_count());
			t.put("tox_effect", tmp.getTox_effect());
			t.put("tox_values", tmp.getTox_values());
			t.put("toxic_code", tmp.getToxic_code());

			toxic.add(t);			
		}
		
		out.print(key + "(" + toxic.toJSONString()+ ")");
		System.out.println("결과 : " + key + "(" + toxic.toJSONString()+ ")");	
		out.flush();
		out.close();
	}	
}
