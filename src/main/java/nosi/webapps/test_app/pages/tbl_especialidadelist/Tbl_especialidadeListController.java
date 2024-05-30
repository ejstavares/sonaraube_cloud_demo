/*-------------------------*/

/*Create Controller*/

package nosi.webapps.test_app.pages.tbl_especialidadelist;

import nosi.core.webapp.Controller;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//


/*----#start-code(packages_import)----*/


/*----#end-code----*/


public class Tbl_especialidadeListController extends Controller {
		

	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		var model = new Tbl_especialidadeList();
		model.load();
		var view = new Tbl_especialidadeListView();
		/*----#start-code(index)----*/

		Core.setMessageInfo("debug... HotSwapAgent");
		nosi.core.webapp.databse.helpers.QueryInterface query = Core.query("test_app_postgresql_1","SELECT id as id,nome as nome,estado as estado FROM public.tbl_especialidade");
		model.loadTable_1(query);
		
		view.id.setParam(true);
		/*----#end-code----*/
		view.setModel(model);
		
		view.id.setParam(true);
		return this.renderView(view);
	}


	public Response actionNew() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*----#start-code(new)----*/
		
		/*----#end-code----*/
		return this.redirect("test_app","Tbl_especialidadeForm","index");
	}

	public Response actionUpdate() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*----#start-code(update)----*/
		this.addQueryString("target","_blank");
		this.addQueryString("isEdit","true");
		this.addQueryString("p_id",Core.getParam("p_id"));
		/*----#end-code----*/
		return this.redirect("test_app","Tbl_especialidadeForm","index",this.queryString());
	}

	public Response actionDelete() throws IOException, IllegalArgumentException, IllegalAccessException{
		var model = new Tbl_especialidadeList.Table_1();
		/*----#start-code(delete)----*/
		nosi.core.webapp.databse.helpers.ResultSet r = Core.delete("test_app_postgresql_1","public","tbl_especialidade").where("id=:id")
				.addInt("id",Core.getParamInt("p_id"))
				.execute();
		if(!r.hasError())
			Core.setMessageSuccess();
		else
			Core.setMessageError();
		/*----#end-code----*/
		return this.redirect("test_app","Tbl_especialidadeList","index");
	}
}
