package nosi.webapps.test_app.dao;

import javax.persistence.Id;
import jakarta.validation.constraints.Size;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.NamedQuery;
import javax.persistence.GeneratedValue;
import javax.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serial;
import javax.persistence.Entity;

/**
 * @author: Nositeste 2024-05-15
 */

//@XmlRootElement // Can be used for REST / XML API

@Entity
@Table(name = "tbl_especialidade", schema = "public")
@NamedQuery(name = "TblEspecialidade.findAll", query = "SELECT t FROM TblEspecialidade t")
public class TblEspecialidade extends BaseActiveRecord<TblEspecialidade> {

    @Serial
    private static final long serialVersionUID = 1L;

    public static final String TABLE_NAME = "TBL_ESPECIALIDADE";

    // Change Integer type to BigDecimal if the number is very large

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
 	private Integer id;
	@NotBlank
	@Size(max = 255)
	@Column(name = "nome")
	private String nome;
	@Size(max = 100)
	@Column(name = "estado")
	private String estado;

   public Integer getId() {
      return this.id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getEstado() {
      return this.estado;
   }

   public void setEstado(String estado) {
      this.estado = estado;
   }

   public static final class Field {
      public static final String ID = "id";
      public static final String NOME = "nome";
      public static final String ESTADO = "estado";

	  private Field() {}
	}
}