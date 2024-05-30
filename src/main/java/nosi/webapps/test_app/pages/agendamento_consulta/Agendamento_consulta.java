package nosi.webapps.test_app.pages.agendamento_consulta;

import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class Agendamento_consulta extends Model{		

	@RParam(rParamName = "p_data_consulta")
	private String data_consulta;

	@RParam(rParamName = "p_especialidade")
	private String[] especialidade;

	@RParam(rParamName = "p_medico")
	private String medico;
	
	private List<Table_1> table_1 = new ArrayList<>();	
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> getTable_1(){
		return this.table_1;
	}

	
	public void setData_consulta(String data_consulta){
		this.data_consulta = data_consulta;
	}
	public String getData_consulta(){
		return this.data_consulta;
	}
	
	public void setEspecialidade(String[] especialidade){
		this.especialidade = especialidade;
	}
	public String[] getEspecialidade(){
		return this.especialidade;
	}
	
	public void setMedico(String medico){
		this.medico = medico;
	}
	public String getMedico(){
		return this.medico;
	}


	public static class Table_1 extends IGRPTable.Table{
		private String especialidade_tbl;
		private String medico_tbl;
		private String hora_inicio;
		private String hora_fim;
		private int selecionar;
		private int selecionar_check;
		public void setEspecialidade_tbl(String especialidade_tbl){
			this.especialidade_tbl = especialidade_tbl;
		}
		public String getEspecialidade_tbl(){
			return this.especialidade_tbl;
		}

		public void setMedico_tbl(String medico_tbl){
			this.medico_tbl = medico_tbl;
		}
		public String getMedico_tbl(){
			return this.medico_tbl;
		}

		public void setHora_inicio(String hora_inicio){
			this.hora_inicio = hora_inicio;
		}
		public String getHora_inicio(){
			return this.hora_inicio;
		}

		public void setHora_fim(String hora_fim){
			this.hora_fim = hora_fim;
		}
		public String getHora_fim(){
			return this.hora_fim;
		}

		public void setSelecionar(int selecionar){
			this.selecionar = selecionar;
		}
		public int getSelecionar(){
			return this.selecionar;
		}
		public void setSelecionar_check(int selecionar_check){
			this.selecionar_check = selecionar_check;
		}
		public int getSelecionar_check(){
			return this.selecionar_check;
		}

	}

	public void loadTable_1(BaseQueryInterface query) {
		this.setTable_1(this.loadTable(query,Table_1.class));
	}

}
