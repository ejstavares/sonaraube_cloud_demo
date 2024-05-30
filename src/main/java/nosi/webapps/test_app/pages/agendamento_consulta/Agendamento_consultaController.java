package nosi.webapps.test_app.pages.agendamento_consulta;

import nosi.core.webapp.Controller;//
import java.io.IOException;//
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class Agendamento_consultaController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		var model = new Agendamento_consulta();
		model.load();
		var view = new Agendamento_consultaView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadTable_1(Core.query(null,"SELECT 'Voluptatem accusantium amet om' as especialidade_tbl,'Aperiam labore aperiam accusan' as medico_tbl,'Voluptatem aliqua accusantium' as hora_inicio,'Sed amet consectetur iste laud' as hora_fim,'1' as selecionar "));
		view.especialidade.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		view.medico.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/* Start-Code-Block (index) *//* End-Code-Block (index) */
		/*----#start-code(index)----*/
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}
