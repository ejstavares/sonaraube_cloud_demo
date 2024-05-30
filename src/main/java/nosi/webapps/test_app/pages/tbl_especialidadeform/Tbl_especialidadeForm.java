/*---------------------- Create Model ----------------------*/
package nosi.webapps.test_app.pages.tbl_especialidadeform;

import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;

public class Tbl_especialidadeForm extends Model{		

	@RParam(rParamName = "p_id")
	private Integer id;

	@RParam(rParamName = "p_nome")
	private String nome;

	@RParam(rParamName = "p_estado")
	private String estado;
	
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getId(){
		return this.id;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setEstado(String estado){
		this.estado = estado;
	}
	public String getEstado(){
		return this.estado;
	}



}
/*-------------------------*/