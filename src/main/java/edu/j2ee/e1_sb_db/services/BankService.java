package edu.j2ee.e1_sb_db.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import edu.j2ee.e1_sb_db.dto.BankDto;
import edu.j2ee.e1_sb_db.dto.UpdateBankTypeRequestDto;

public interface BankService {
	// Abstract Service methods:
	public BankDto getBank(int id);

	public List<BankDto> getAllBanks();

	public BankDto getBankByCode(String code);

	public BankDto getBankByNameAndType(
			String name, String type);
	
	//Pagination
	public Page<BankDto> findBanks(Pageable pageable); 

	public BankDto createBank(BankDto bankDto);
	
	public List<BankDto> addBulkBanks();
	
	public BankDto updateBank(int id, BankDto bankDto);

	// Updating Single field
	public BankDto updateBankType(int id, UpdateBankTypeRequestDto dto);

	public void deleteBank(int id);

	public void deleteAllBanks();
	
}
