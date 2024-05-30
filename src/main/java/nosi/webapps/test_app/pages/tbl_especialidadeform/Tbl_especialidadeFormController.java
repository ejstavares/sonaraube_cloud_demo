/*-------------------------*/

/*Create Controller*/

package nosi.webapps.test_app.pages.tbl_especialidadeform;

import nosi.core.webapp.Controller;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//


/*----#start-code(packages_import)----*/


/*----#end-code----*/


public class Tbl_especialidadeFormController extends Controller {
		

	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		var model = new Tbl_especialidadeForm();
		model.load();
		
		var view = new Tbl_especialidadeFormView();
		/*----#start-code(index)----*/
		String isEdit = Core.getParam("isEdit");
 			
		if(Core.isNotNull(isEdit)) {
		nosi.core.webapp.databse.helpers.QueryInterface query = Core.query("test_app_postgresql_1","SELECT id as id,nome as nome,estado as estado FROM public.tbl_especialidade")
				.where("id=:id")
				.addInt("id",model.getId());
		model.load(query);
		view.btn_save.setLink("save&isEdit=true");
		}
		/*----#end-code----*/
		view.setModel(model);
		
		return this.renderView(view);
	}


	public Response actionList() throws IOException, IllegalArgumentException, IllegalAccessException{
		/*----#start-code(list)----*/
		
		/*----#end-code----*/
		return this.redirect("test_app","Tbl_especialidadeList","index");
	}

	public Response actionSave() throws IOException, IllegalArgumentException, IllegalAccessException{
		var model = new Tbl_especialidadeForm();
		model.load();
		/*----#start-code(save)----*/
		nosi.core.webapp.databse.helpers.ResultSet r = null;
		
		String isEdit = Core.getParam("isEdit");;
		 	
		if(Core.isNull(isEdit)){
			r = Core.insert("test_app_postgresql_1","public","tbl_especialidade")		
				.addString("nome",model.getNome())
				.addString("estado",model.getEstado())
				.execute();
		}else{
			r = Core.update("test_app_postgresql_1","public","tbl_especialidade")		
				.addString("nome",model.getNome())
				.addString("estado",model.getEstado())
				.where("id=:id")
				.addInt("id",model.getId())
				.execute();
		}
		if(!r.hasError()){
			Core.setMessageSuccess();
		 }else{
			Core.setMessageError();
			 return this.forward("test_app","Tbl_especialidadeForm","index");
		}
		/*----#end-code----*/
		return this.redirect("test_app","Tbl_especialidadeForm","index");
	}
}
