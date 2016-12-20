package br.com.entelgy.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.entelgy.models.Invoice;
import br.com.entelgy.repository.IngridientRepository;
import br.com.entelgy.repository.InvoiceRepository;
import br.com.entelgy.repository.SnackRepository;

@Component("invoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService{
	
	@Autowired
	private InvoiceRepository invoiceRepository;
	
	@Autowired
	private SnackRepository snackRepository;
	
	@Autowired
	private IngridientRepository ingridientRepository;

	@Override
	public Invoice save(Invoice invoice) {
		//validateEntity(invoice);
		return invoiceRepository.save(invoice);
	}

	@Override
	public Invoice getById(Integer id) {
		return invoiceRepository.findOne(id);
	}

	@Override
	public List<Invoice> findAllUndelivered() {
		return invoiceRepository.findInvoicesUndelivered();
	}

}
