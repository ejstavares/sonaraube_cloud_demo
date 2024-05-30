/*---------------------- Create Model ----------------------*/
package nosi.webapps.test_app.pages.tbl_especialidadelist;

import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class Tbl_especialidadeList extends Model{		
	
	private List<Table_1> table_1 = new ArrayList<>();	
	public void setTable_1(List<Table_1> table_1){
		this.table_1 = table_1;
	}
	public List<Table_1> getTable_1(){
		return this.table_1;
	}



	public static class Table_1 extends IGRPTable.Table{
		private Integer id;
		private String nome;
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

	public void loadTable_1(BaseQueryInterface query) {
		this.setTable_1(this.loadTable(query,Table_1.class));
	}

}
/*-------------------------*/