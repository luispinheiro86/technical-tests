package com.jpmorgan.message.model;

import java.io.Serializable;

import com.jpmorgan.message.utils.OperationEnum;

public class Message implements Serializable {
	
	private static final long serialVersionUID = 5474218210325976349L;

	private Sale sale;
	
	private Integer nOccurrences;
	
	private OperationEnum operation; 
	
	private Integer adjustment;
	
	public Message(Sale sale) {
		this.sale = sale;
	}
	
	public Message(Sale sale, Integer nOccurrences) {
		this.sale = sale;
		this.nOccurrences = nOccurrences;
	}
	
	public Message(Sale sale, OperationEnum operation, Integer adjustment) {
		this.sale = sale;
		this.operation = operation;
		this.nOccurrences = adjustment;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Integer getnOccurrences() {
		return nOccurrences;
	}

	public void setnOccurrences(Integer nOccurrences) {
		this.nOccurrences = nOccurrences;
	}

	public OperationEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}

	public Integer getAdjustment() {
		return adjustment;
	}

	public void setAdjustment(Integer adjustment) {
		this.adjustment = adjustment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adjustment == null) ? 0 : adjustment.hashCode());
		result = prime * result + ((nOccurrences == null) ? 0 : nOccurrences.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		result = prime * result + ((sale == null) ? 0 : sale.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (adjustment == null) {
			if (other.adjustment != null)
				return false;
		} else if (!adjustment.equals(other.adjustment))
			return false;
		if (nOccurrences == null) {
			if (other.nOccurrences != null)
				return false;
		} else if (!nOccurrences.equals(other.nOccurrences))
			return false;
		if (operation != other.operation)
			return false;
		if (sale == null) {
			if (other.sale != null)
				return false;
		} else if (!sale.equals(other.sale))
			return false;
		return true;
	}
	
}
