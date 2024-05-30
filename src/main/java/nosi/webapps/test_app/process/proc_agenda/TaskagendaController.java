package nosi.webapps.test_app.process.proc_agenda;

import java.io.IOException;//
import java.util.List;//
import nosi.core.webapp.Response;//
import jakarta.servlet.ServletException;//
import nosi.core.webapp.Core;//
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;//
import nosi.core.webapp.bpmn.BPMNTaskController;//
import nosi.webapps.test_app.pages.agendamento_consulta.Agendamento_consulta;//
import nosi.webapps.test_app.pages.agendamento_consulta.Agendamento_consultaView;//
/*----#start-code(packages_import)----*/

/*----#end-code----*/



/**
 *demo@nosi.cv
 *28-05-2024
*/

public class TaskagendaController extends BPMNTaskController {

	public Response actionIndex() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		var view = new Agendamento_consultaView();
		var model = new Agendamento_consulta();
		model.load();

		/*----#start-code(index)----*/

		/*----#end-code----*/

		return super.index("test_app",model,view,this);
	}

	public Response actionSave() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/

		/*----#end-code----*/

		return super.save();
	}

	public List<TipoDocumentoEtapa> getInputDocumentType() {
		return super.getInputDocumentType();
	}

	public List<TipoDocumentoEtapa> getOutputDocumentType() {
		return super.getOutputDocumentType();
	}



	/*----#start-code(custom_actions)----*/

	/*----#end-code----*/



}
