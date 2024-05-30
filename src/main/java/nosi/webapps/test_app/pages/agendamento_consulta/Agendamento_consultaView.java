package nosi.webapps.test_app.pages.agendamento_consulta;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Agendamento_consultaView extends View {

	public Field data_consulta;
	public Field especialidade;
	public Field medico;
	public Field especialidade_tbl;
	public Field medico_tbl;
	public Field hora_inicio;
	public Field hora_fim;
	public Field selecionar;
	public Field selecionar_check;
	public IGRPForm form_1;
	public IGRPTable table_1;


	public Agendamento_consultaView(){

		this.setPageTitle("Agendamento Consulta");
			
		form_1 = new IGRPForm("form_1","");

		table_1 = new IGRPTable("table_1","");

		data_consulta = new DateField(model,"data_consulta");
		data_consulta.setLabel(gt("Data Consulta"));
		data_consulta.propertie().add("name","p_data_consulta").add("type","date").add("range","false").add("disableWeekends","false").add("disabledBeforetoday","false").add("daysoff","false").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		especialidade = new ListField(model,"especialidade");
		especialidade.setLabel(gt("Especialidade"));
		especialidade.propertie().add("name","p_especialidade").add("type","select").add("multiple","true").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		medico = new ListField(model,"medico");
		medico.setLabel(gt("Medico"));
		medico.propertie().add("name","p_medico").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		especialidade_tbl = new PlainTextField(model,"especialidade_tbl");
		especialidade_tbl.setLabel(gt("Especialidade"));
		especialidade_tbl.propertie().add("name","p_especialidade_tbl").add("type","plaintext").add("disable_output_escaping","false").add("html_class","").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		medico_tbl = new PlainTextField(model,"medico_tbl");
		medico_tbl.setLabel(gt("Medico"));
		medico_tbl.propertie().add("name","p_medico_tbl").add("type","plaintext").add("disable_output_escaping","false").add("html_class","").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		hora_inicio = new PlainTextField(model,"hora_inicio");
		hora_inicio.setLabel(gt("Hora Inicio"));
		hora_inicio.propertie().add("name","p_hora_inicio").add("type","plaintext").add("disable_output_escaping","false").add("html_class","").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		hora_fim = new PlainTextField(model,"hora_fim");
		hora_fim.setLabel(gt("Hora Fim"));
		hora_fim.propertie().add("name","p_hora_fim").add("type","plaintext").add("disable_output_escaping","false").add("html_class","").add("maxlength","30").add("showLabel","true").add("group_in","");
		
		selecionar = new CheckBoxField(model,"selecionar");
		selecionar.setLabel(gt("Selecionar"));
		selecionar.propertie().add("name","p_selecionar").add("type","checkbox").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","int").add("switch","false").add("check","true").add("desc","true");
		
		selecionar_check = new CheckBoxField(model,"selecionar_check");
		selecionar_check.propertie().add("name","p_selecionar").add("type","checkbox").add("maxlength","30").add("showLabel","true").add("group_in","").add("java-type","int").add("switch","false").add("check","true").add("desc","true");
		


		
	}
		
	@Override
	public void render(){
		
		form_1.addField(data_consulta);
		form_1.addField(especialidade);
		form_1.addField(medico);

		table_1.addField(especialidade_tbl);
		table_1.addField(medico_tbl);
		table_1.addField(hora_inicio);
		table_1.addField(hora_fim);
		table_1.addField(selecionar);
		table_1.addField(selecionar_check);

		this.addToPage(form_1);
		this.addToPage(table_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		data_consulta.setValue(model);
		especialidade.setValue(model);
		medico.setValue(model);
		especialidade_tbl.setValue(model);
		medico_tbl.setValue(model);
		hora_inicio.setValue(model);
		hora_fim.setValue(model);
		selecionar.setValue(model);	

		table_1.loadModel(((Agendamento_consulta) model).getTable_1());
		}
}
