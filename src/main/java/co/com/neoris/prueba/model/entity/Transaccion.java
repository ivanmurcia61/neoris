package co.com.neoris.prueba.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="transacciones")
public class Transaccion {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTransaction;
	
	@Column(name = "account_number", nullable = false, length = 60)
    private String accountNumber;
	
	@Column(name = "amount_transaction", nullable = false, length = 60)
    private String amountTransaction;
	
	@Column(name = "create_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@ManyToOne
    @JoinColumn(name = "idCuentaBancaria", referencedColumnName = "idCuentaBancaria", nullable = false, updatable = false)
    private CuentaBancaria cuentaBancaria;
	
	
	@PrePersist
	public void prePersist() {
		this.createAt = new Date();
	}
	
	public Transaccion(long idTransaction, String amountTransaction, String accountNumber, CuentaBancaria cuentaBancaria) {
        this.idTransaction = idTransaction;
        this.accountNumber = accountNumber;
        this.amountTransaction = amountTransaction;
        this.cuentaBancaria = cuentaBancaria;
    }


	public long getIdTransaction() {
		return idTransaction;
	}


	public void setIdTransaction(long idTransaction) {
		this.idTransaction = idTransaction;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getAmountTransaction() {
		return amountTransaction;
	}


	public void setAmountTransaction(String amountTransaction) {
		this.amountTransaction = amountTransaction;
	}


	public Date getCreateAt() {
		return createAt;
	}


	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}


	public CuentaBancaria getCuentaBancaria() {
		return cuentaBancaria;
	}


	public void setCuentasBancarias(CuentaBancaria cuentaBancaria) {
		this.cuentaBancaria = cuentaBancaria;
	}


	@Override
	public String toString() {
		return "Transaccion [idTransaction=" + idTransaction + ", accountNumber=" + accountNumber
				+ ", amountTransaction=" + amountTransaction + ", createAt=" + createAt + ", cuentaBancaria="
				+ cuentaBancaria + "]";
	}
		
}
