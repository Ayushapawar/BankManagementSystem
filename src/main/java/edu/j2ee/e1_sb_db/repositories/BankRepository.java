package edu.j2ee.e1_sb_db.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.j2ee.e1_sb_db.entities.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
	public Optional<Bank> findByCode(String code);
	
	@Query("Select b from Bank b"
		 + " where b.name=:name"
		 + " and b.type=:bankType")
	public Bank getBankByNameAndType(
		String name,@Param("bankType") String type);
	
}
