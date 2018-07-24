package com.jpmorgan.message.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.jpmorgan.message.model.Message;
import com.jpmorgan.message.model.Sale;
import com.jpmorgan.message.service.MessageService;
import com.jpmorgan.message.utils.MessageLimitEnum;
import com.jpmorgan.message.utils.MessageTypeEnum;

@Service
public class MessageServiceImpl implements MessageService {

	// private static final Logger LOGGER = Logger

	private Map<String, List<Sale>> messages = new HashMap<String, List<Sale>>();
	private static Integer NUMBER_MESSAGES = 0;

	@Override
	public void processMessage(Message message) {
		MessageTypeEnum messageType = checkMessageType(message);
		switch (messageType) {
		case MESSAGE_TYPE_ONE:
			registerSale(message);
			NUMBER_MESSAGES++;
			break;
		case MESSAGE_TYPE_TWO:
			registerSale(message);
			
			NUMBER_MESSAGES++;
			break;
		case MESSAGE_TYPE_THREE:

			NUMBER_MESSAGES++;
			break;
		default:
			break;
		}
		checkNumberProcessedMessages();
	}

	private void registerSale(Message message) {
		List<Sale> sales = messages.get(message.getSale().getProduct().getName());
		if(CollectionUtils.isEmpty(sales)) {
			sales = new ArrayList<Sale>();
			sales.add(message.getSale());
			messages.put(message.getSale().getProduct().getName(), sales);
		} else {
			sales.add(message.getSale());
		}
	}

	private void checkNumberProcessedMessages() {
		if (NUMBER_MESSAGES % 10 == 0) {
			printResumeLog(MessageLimitEnum.LIMIT_10);
		}
		if (NUMBER_MESSAGES == 50) {
			printResumeLog(MessageLimitEnum.LIMIT_50);
		}
	}

	private void printResumeLog(MessageLimitEnum limit) {
		switch (limit) {
		case LIMIT_10:
			System.out.println("10000000000000000000000");
			break;
			
		default:
			break;
		}

	}

	private MessageTypeEnum checkMessageType(Message message) {
		if (Objects.isNull(message) || Objects.isNull(message.getSale()) || Objects.isNull(message.getSale().getProduct())) {
			return null;
		}
		if (Objects.nonNull(message.getOperation()) && Objects.nonNull(message.getAdjustment())) {
			return MessageTypeEnum.MESSAGE_TYPE_THREE;
		} else if (Objects.nonNull(message.getnOccurrences()) && Objects.isNull(message.getOperation())) {
			return MessageTypeEnum.MESSAGE_TYPE_TWO;
		} else if (Objects.isNull(message.getOperation()) && Objects.isNull(message.getnOccurrences())) {
			return MessageTypeEnum.MESSAGE_TYPE_ONE;
		} else {
			return null;
		}
	}

}
