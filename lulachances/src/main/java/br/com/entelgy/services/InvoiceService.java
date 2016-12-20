package br.com.entelgy.services;

import java.util.List;

import br.com.entelgy.models.Invoice;

public interface InvoiceService {
	
	Invoice save(Invoice invoice);
	
	Invoice getById(Integer id);
	
	List<Invoice> findAllUndelivered();
}
