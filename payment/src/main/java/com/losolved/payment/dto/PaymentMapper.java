package com.losolved.payment.dto;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import com.losolved.payment.model.Payment;

public class PaymentMapper {
	
	private ModelMapper mapper = new ModelMapper();

	public Payment convertDTOToEntity(PaymentDTO paymentDTO) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 
		Payment payment = mapper.map(paymentDTO, Payment.class);
		return payment;
	
	}

	public PaymentDTO convertEntityToDTO(Payment payment) {
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // 
		PaymentDTO paymentDTO = mapper.map(payment, PaymentDTO.class);
		return paymentDTO;
	}

}
