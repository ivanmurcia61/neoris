package co.com.neoris.prueba.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column(name = "names", nullable = false, length = 80)
	private String names;
	
	@Column(name = "lastnames", nullable = false, length = 80)
	private String lastnames;
	
	@Column(name = "cedula", nullable = false, length = 20)
	private String cedula;
	
	@Column(name = "typeDocument", nullable = false, length = 3)
	private String typeDocument;
	
	@Column(name = "phoneContact", nullable = true, length = 20)
	private String phoneContact;
	
	@Column(name = "email", nullable = true, length = 160)
	private String email;
	
	@Column(name = "create_At")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getTypeDocument() {
		return typeDocument;
	}

	public void setTypeDocument(String typeDocument) {
		this.typeDocument = typeDocument;
	}

	public String getPhoneContact() {
		return phoneContact;
	}

	public void setPhoneContact(String phoneContact) {
		this.phoneContact = phoneContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", names=" + names + ", lastnames=" + lastnames + ", cedula="
				+ cedula + ", typeDocument=" + typeDocument + ", phoneContact=" + phoneContact + ", email=" + email
				+ ", createAt=" + createAt + "]";
	}
	
	
}
