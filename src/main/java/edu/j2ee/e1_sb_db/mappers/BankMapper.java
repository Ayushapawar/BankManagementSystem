package edu.j2ee.e1_sb_db.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.j2ee.e1_sb_db.dto.BankDto;
import edu.j2ee.e1_sb_db.entities.Bank;

@Component
public class BankMapper {
	@Autowired
	private ModelMapper mapper;

	public Bank toEntity(BankDto dto) {
		return mapper.map(dto, Bank.class);
	}

	public BankDto toDto(Bank bank) {
		return mapper.map(bank, BankDto.class);
	}

}
