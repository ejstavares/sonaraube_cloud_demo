/*-------------------------*/

/*Create View*/
package nosi.webapps.test_app.pages.tbl_especialidadelist;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Tbl_especialidadeListView extends View {

	public Field id;
	public Field nome;
	public Field estado;
	public IGRPTable table_1;

	public IGRPToolsBar toolsbar_1;
	public IGRPButton btn_new;
	public IGRPButton btn_update;
	public IGRPButton btn_delete;

	public Tbl_especialidadeListView(){

		this.setPageTitle("");
			
		table_1 = new IGRPTable("table_1","Listar especialidade");

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

		btn_new = new IGRPButton("Novo","test_app","Tbl_especialidadeList","new","modal|refresh","success|fa-plus","","");
		btn_new.propertie.add("crud_op","addNew").add("action-id","86").add("rel","new").add("type","specific");

		btn_update = new IGRPButton("Editar","test_app","Tbl_especialidadeList","update","mpsubmit|refresh","warning|fa-pencil","","");
		btn_update.propertie.add("crud_op","edit").add("action-id","86").add("rel","update").add("type","specific");

		btn_delete = new IGRPButton("Eliminar","test_app","Tbl_especialidadeList","delete","confirm","danger|fa-trash","","");
		btn_delete.propertie.add("crud_op","delete").add("action-id","87").add("rel","delete").add("type","specific");

		
	}
		
	@Override
	public void render(){
		

		table_1.addField(id);
		table_1.addField(nome);
		table_1.addField(estado);

		toolsbar_1.addButton(btn_new);
		table_1.addButton(btn_update);
		table_1.addButton(btn_delete);
		this.addToPage(table_1);
		this.addToPage(toolsbar_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		id.setValue(model);
		nome.setValue(model);
		estado.setValue(model);	

		table_1.loadModel(((Tbl_especialidadeList) model).getTable_1());
		}
}
/*-------------------------*/