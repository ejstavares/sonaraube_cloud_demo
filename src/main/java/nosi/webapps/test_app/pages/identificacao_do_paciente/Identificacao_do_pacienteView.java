package nosi.webapps.test_app.pages.identificacao_do_paciente;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;

public class Identificacao_do_pacienteView extends View {

	public Field nome;
	public Field data_nascimento;
	public Field tipo_documento;
	public Field numero_documento;
	public Field informacao_adicional;
	public Field primeira_consulta;
	public Field data_ultima_consulta;
	public Field nome_mae;
	public Field nome_pai;
	public Field tipo_documento_anexar;
	public Field anexar_documento;
	public IGRPForm form_1;


	public Identificacao_do_pacienteView(){

		this.setPageTitle("Identificaçao do Paciente");
			
		form_1 = new IGRPForm("form_1","");

		nome = new TextField(model,"nome");
		nome.setLabel(gt("Nome"));
		nome.propertie().add("name","p_nome").add("type","text").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		data_nascimento = new DateField(model,"data_nascimento");
		data_nascimento.setLabel(gt("Data Nascimento"));
		data_nascimento.propertie().add("name","p_data_nascimento").add("type","date").add("range","false").add("disableWeekends","false").add("disabledBeforetoday","false").add("daysoff","false").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		tipo_documento = new ListField(model,"tipo_documento");
		tipo_documento.setLabel(gt("Tipo Documento"));
		tipo_documento.propertie().add("name","p_tipo_documento").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","true").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		numero_documento = new NumberField(model,"numero_documento");
		numero_documento.setLabel(gt("Numero Documento"));
		numero_documento.propertie().add("name","p_numero_documento").add("type","number").add("min","").add("max","").add("calculation","false").add("mathcal","").add("numberformat","").add("maxlength","250").add("required","true").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		informacao_adicional = new SeparatorField(model,"informacao_adicional");
		informacao_adicional.setLabel(gt("Informacao Adicional"));
		informacao_adicional.propertie().add("name","p_informacao_adicional").add("type","separator").add("maxlength","250").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false");
		
		primeira_consulta = new RadioListField(model,"primeira_consulta");
		primeira_consulta.setLabel(gt("Primeira Consulta?"));
		primeira_consulta.propertie().add("name","p_primeira_consulta").add("type","radiolist").add("domain","").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("child_size","12").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		data_ultima_consulta = new DateField(model,"data_ultima_consulta");
		data_ultima_consulta.setLabel(gt("Data Ultima Consulta"));
		data_ultima_consulta.propertie().add("name","p_data_ultima_consulta").add("type","date").add("range","false").add("disableWeekends","false").add("disabledBeforetoday","false").add("daysoff","false").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("placeholder",gt("")).add("desclabel","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		
		nome_mae = new TextField(model,"nome_mae");
		nome_mae.setLabel(gt("Nome Mae"));
		nome_mae.propertie().add("name","p_nome_mae").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		nome_pai = new TextField(model,"nome_pai");
		nome_pai.setLabel(gt("Nome Pai"));
		nome_pai.propertie().add("name","p_nome_pai").add("type","text").add("maxlength","250").add("required","false").add("readonly","false").add("disabled","false").add("disablehtml","true").add("placeholder",gt("")).add("desclabel","false").add("inputmask","").add("tooltip","false").add("disable_copy_paste","false");
		
		tipo_documento_anexar = new ListField(model,"tipo_documento_anexar");
		tipo_documento_anexar.setLabel(gt("Tipo Documento"));
		tipo_documento_anexar.propertie().add("name","p_tipo_documento_anexar").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		anexar_documento = new FileField(model,"anexar_documento");
		anexar_documento.setLabel(gt("Anexar Documento"));
		anexar_documento.propertie().add("name","p_anexar_documento").add("type","file").add("accept","").add("targetrend","").add("multiple","false").add("rendvalue","false").add("maxlength","250").add("required","false").add("disabled","false").add("tooltip","false").add("disable_copy_paste","false").add("class","primary");
		


		
	}
		
	@Override
	public void render(){
		
		form_1.addField(nome);
		form_1.addField(data_nascimento);
		form_1.addField(tipo_documento);
		form_1.addField(numero_documento);
		form_1.addField(informacao_adicional);
		form_1.addField(primeira_consulta);
		form_1.addField(data_ultima_consulta);
		form_1.addField(nome_mae);
		form_1.addField(nome_pai);
		form_1.addField(tipo_documento_anexar);
		form_1.addField(anexar_documento);

		this.addToPage(form_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		nome.setValue(model);
		data_nascimento.setValue(model);
		tipo_documento.setValue(model);
		numero_documento.setValue(model);
		informacao_adicional.setValue(model);
		primeira_consulta.setValue(model);
		data_ultima_consulta.setValue(model);
		nome_mae.setValue(model);
		nome_pai.setValue(model);
		tipo_documento_anexar.setValue(model);
		anexar_documento.setValue(model);	

		}
}
