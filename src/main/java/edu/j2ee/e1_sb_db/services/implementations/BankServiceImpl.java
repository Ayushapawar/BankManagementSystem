package edu.j2ee.e1_sb_db.services.implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import edu.j2ee.e1_sb_db.dto.BankDto;
import edu.j2ee.e1_sb_db.dto.UpdateBankTypeRequestDto;
import edu.j2ee.e1_sb_db.entities.Bank;
import edu.j2ee.e1_sb_db.exceptionHandlers.ResourceNotFoundException;
import edu.j2ee.e1_sb_db.mappers.BankMapper;
import edu.j2ee.e1_sb_db.repositories.BankRepository;
import edu.j2ee.e1_sb_db.services.BankService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BankServiceImpl implements BankService {

	private final BankRepository bankRepository;
	private final BankMapper bankMapper;

	@Override
	public BankDto getBank(int id) {
		Bank bank = bankRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Bank not found!!!"));

		return bankMapper.toDto(bank);
	}

	@Override
	public List<BankDto> getAllBanks() {
		List<Bank> banks = bankRepository.findAll();
		return banks.stream().map(bank -> bankMapper.toDto(bank)).toList();
	}

	@Override
	public BankDto getBankByCode(String code) {
		Optional<Bank> bank = bankRepository.findByCode(code);
		if (bank.isPresent()) {
			return bankMapper.toDto(bank.get());
		}
		return null;
	}

	@Override
	public BankDto getBankByNameAndType(String name, String type) {
		Bank bank = bankRepository.getBankByNameAndType(name, type);
		return bankMapper.toDto(bank);
	}
	
	@Override
	public Page<BankDto> findBanks(Pageable pageable) {
		Page<Bank> banks = 
			bankRepository.findAll(pageable);
		
		return banks.map(bankMapper::toDto);
	}

	@Override
	public BankDto createBank(BankDto bankDto) {
		Bank newBank = bankRepository.save(bankMapper.toEntity(bankDto));
		return bankMapper.toDto(newBank);
	}
	
	@Override
	public List<BankDto> addBulkBanks() {
		
		List<Bank> banks = new ArrayList<Bank>();
		banks.add(
		new Bank("Swiss Bank", "SWISS", "International"));
		banks.add(
		new Bank("Canara Bank", "CAN", "private"));
		banks.add(
		new Bank("City Bank", "CITY", "state"));
		banks.add(
		new Bank("Punjab National Bank", "PNB", "state"));
		
		bankRepository.saveAll(banks);
		
		return banks.stream()
				.map(bankMapper::toDto)
				.toList();
	}

	@Override
	public BankDto updateBank(int id, BankDto bankDto) {
		// Fetching
		Bank existingBank = bankRepository.findById(id).orElseThrow(() -> new RuntimeException("Bank not found"));

		// Update
		existingBank.setName(bankDto.getName());
		existingBank.setCode(bankDto.getCode());
		existingBank.setType(bankDto.getType());

		Bank updatedBank = bankRepository.save(existingBank);

		return bankMapper.toDto(updatedBank);
	}

	@Override
	public BankDto updateBankType(int id, UpdateBankTypeRequestDto dto) {
		Bank existingBank = bankRepository.findById(id).get();

		existingBank.setType(dto.getType());

		Bank updatedBank = bankRepository.save(existingBank);
		return bankMapper.toDto(updatedBank);
	}

	@Override
	public void deleteBank(int id) {
		bankRepository.deleteById(id);
	}

	@Override
	public void deleteAllBanks() {
		bankRepository.deleteAll();
	}
}
