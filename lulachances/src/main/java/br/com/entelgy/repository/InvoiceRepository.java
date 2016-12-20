package br.com.entelgy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.entelgy.models.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Integer>{
	
	List<Invoice> findInvoicesUndelivered();
	
}
