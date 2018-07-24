package com.jpmorgan.message.model;

import com.jpmorgan.message.utils.OperationEnum;

public class MessageTypeThree extends BaseMessage {

	private OperationEnum operation; 
	
	private Integer adjustment;
	
	public MessageTypeThree(Sale sale, OperationEnum operation, Integer adjustment) {
		this.sale = sale;
		this.operation = operation;
		this.adjustment = adjustment;
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
		int result = super.hashCode();
		result = prime * result + ((adjustment == null) ? 0 : adjustment.hashCode());
		result = prime * result + ((operation == null) ? 0 : operation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MessageTypeThree other = (MessageTypeThree) obj;
		if (adjustment == null) {
			if (other.adjustment != null)
				return false;
		} else if (!adjustment.equals(other.adjustment))
			return false;
		if (operation != other.operation)
			return false;
		return true;
	}
	
}
