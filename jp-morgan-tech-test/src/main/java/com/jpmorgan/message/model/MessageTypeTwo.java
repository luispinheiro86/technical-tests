package com.jpmorgan.message.model;

public class MessageTypeTwo extends BaseMessage {

	private Integer nOccurrences = 0 ;
	
	public MessageTypeTwo(Sale sale, Integer nOccurrences) {
		this.sale = sale;
		this.nOccurrences = nOccurrences;
	}

	public Integer getnOccurrences() {
		return nOccurrences;
	}

	public void setnOccurrences(Integer nOccurrences) {
		this.nOccurrences = nOccurrences;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((nOccurrences == null) ? 0 : nOccurrences.hashCode());
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
		MessageTypeTwo other = (MessageTypeTwo) obj;
		if (nOccurrences == null) {
			if (other.nOccurrences != null)
				return false;
		} else if (!nOccurrences.equals(other.nOccurrences))
			return false;
		return true;
	}
	
}
