package nosi.webapps.test_app.pages.identificacao_do_paciente;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.uploadfile.UploadFile;

import nosi.core.validator.constraints.*;

public class Identificacao_do_paciente extends Model{		

	@NotNull()
	@RParam(rParamName = "p_nome")
	private String nome;

	@NotNull()
	@RParam(rParamName = "p_data_nascimento")
	private String data_nascimento;

	@NotNull()
	@RParam(rParamName = "p_tipo_documento")
	private String tipo_documento;

	@NotNull()
	@RParam(rParamName = "p_numero_documento")
	private Integer numero_documento;

	@NotNull()
	@RParam(rParamName = "p_informacao_adicional")
	private String informacao_adicional;

	@RParam(rParamName = "p_primeira_consulta")
	private Integer primeira_consulta;

	@RParam(rParamName = "p_data_ultima_consulta")
	private String data_ultima_consulta;

	@RParam(rParamName = "p_nome_mae")
	private String nome_mae;

	@RParam(rParamName = "p_nome_pai")
	private String nome_pai;

	@RParam(rParamName = "p_tipo_documento_anexar")
	private String tipo_documento_anexar;

	@RParam(rParamName = "p_anexar_documento")
	private UploadFile anexar_documento;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setData_nascimento(String data_nascimento){
		this.data_nascimento = data_nascimento;
	}
	public String getData_nascimento(){
		return this.data_nascimento;
	}
	
	public void setTipo_documento(String tipo_documento){
		this.tipo_documento = tipo_documento;
	}
	public String getTipo_documento(){
		return this.tipo_documento;
	}
	
	public void setNumero_documento(Integer numero_documento){
		this.numero_documento = numero_documento;
	}
	public Integer getNumero_documento(){
		return this.numero_documento;
	}
	
	public void setInformacao_adicional(String informacao_adicional){
		this.informacao_adicional = informacao_adicional;
	}
	public String getInformacao_adicional(){
		return this.informacao_adicional;
	}
	
	public void setPrimeira_consulta(Integer primeira_consulta){
		this.primeira_consulta = primeira_consulta;
	}
	public Integer getPrimeira_consulta(){
		return this.primeira_consulta;
	}
	
	public void setData_ultima_consulta(String data_ultima_consulta){
		this.data_ultima_consulta = data_ultima_consulta;
	}
	public String getData_ultima_consulta(){
		return this.data_ultima_consulta;
	}
	
	public void setNome_mae(String nome_mae){
		this.nome_mae = nome_mae;
	}
	public String getNome_mae(){
		return this.nome_mae;
	}
	
	public void setNome_pai(String nome_pai){
		this.nome_pai = nome_pai;
	}
	public String getNome_pai(){
		return this.nome_pai;
	}
	
	public void setTipo_documento_anexar(String tipo_documento_anexar){
		this.tipo_documento_anexar = tipo_documento_anexar;
	}
	public String getTipo_documento_anexar(){
		return this.tipo_documento_anexar;
	}
	
	public void setAnexar_documento(UploadFile anexar_documento){
		this.anexar_documento = anexar_documento;
	}
	public UploadFile getAnexar_documento(){
		return this.anexar_documento;
	}



}
