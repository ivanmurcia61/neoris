package co.com.neoris.prueba.model.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="cuentasBancarias")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCuentaBancaria;
	
	@Column(name = "currency", nullable = false, length = 5)
	private String currency;
	
	@Column(name = "account_number", nullable = false, length = 50)
	private String accountNumber;
	
	@Column(name = "type_account", nullable = false, length = 50)
	private String typeAccount;
	
	@ManyToOne
	@JoinColumn(name = "idCliente", referencedColumnName = "idCliente", nullable = false, updatable = false)
	private Cliente cliente;
	
	@OneToMany( cascade = CascadeType.ALL, mappedBy = "cuentaBancaria")
	private List<Transaccion> transacciones;
	
	public CuentaBancaria(long idCuentaBancaria, String currency, String accountNumber, String typeAccount, Cliente cliente) {
		this.idCuentaBancaria = idCuentaBancaria;
		this.currency = currency;
		this.accountNumber = accountNumber;
		this.typeAccount = typeAccount;
		this.cliente = cliente;
	}
	

	public long getIdCuentaBancaria() {
		return idCuentaBancaria;
	}

	public void setIdCuentaBancaria(long idCuentaBancaria) {
		this.idCuentaBancaria = idCuentaBancaria;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "CuentaBancaria [idCuentaBancaria=" + idCuentaBancaria + ", currency=" + currency + ", accountNumber="
				+ accountNumber + ", typeAccount=" + typeAccount + ", cliente=" + cliente + "]";
	}
		
}
