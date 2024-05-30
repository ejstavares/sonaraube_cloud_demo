/*-------------------------*/

/*Create View*/
package nosi.webapps.test_app.pages.tbl_especialidadeform;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Tbl_especialidadeFormView extends View {

	public Field id;
	public Field nome;
	public Field estado;
	public IGRPForm form_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_list;
	public IGRPButton btn_save;

	public Tbl_especialidadeFormView(){

		this.setPageTitle("");
			
		form_1 = new IGRPForm("form_1","Registar especialidade");

		id = new HiddenField(model,"id");
		id.setLabel(gt(""));
		id.propertie().add("isAutoincrement","true").add("name","p_id").add("tag","id").add("java-type","Integer").add("type","hidden").add("required","true");
		
		nome = new TextField(model,"nome");
		nome.setLabel(gt("nome"));
		nome.propertie().add("readonly","false").add("maxlength","255").add("name","p_nome").add("disabled","false").add("placeholder",gt("")).add("tag","nome").add("java-type","String").add("type","text").add("required","true");
		
		estado = new TextField(model,"estado");
		estado.setLabel(gt("estado"));
		estado.propertie().add("readonly","false").add("maxlength","100").add("name","p_estado").add("disabled","false").add("placeholder",gt("")).add("java-type","String").add("type","text").add("required","false");
		

		toolsbar_1 = new IGRPToolsBar("toolsbar_1");

		btn_list = new IGRPButton("List","test_app","Tbl_especialidadeForm","list","_self","default|fa-list","","");
		btn_list.propertie.add("crud_op","list").add("action-id","87").add("rel","list").add("type","specific");

		btn_save = new IGRPButton("Gravar","test_app","Tbl_especialidadeForm","save","submit","primary|fa-save","","");
		btn_save.propertie.add("crud_op","save").add("action-id","86").add("rel","save").add("type","specific");

		
	}
		
	@Override
	public void render(){
		

		form_1.addField(id);
		form_1.addField(nome);
		form_1.addField(estado);

		toolsbar_1.addButton(btn_list);
		toolsbar_1.addButton(btn_save);
		this.addToPage(form_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		id.setValue(model);
		nome.setValue(model);
		estado.setValue(model);	

		}
}
/*-------------------------*/