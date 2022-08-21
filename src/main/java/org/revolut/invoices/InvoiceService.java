package org.revolut.invoices;

public class InvoiceService {

    public Invoice create(InvoiceCreateDTO createDTO) {
        if(createDTO.getInvoiceNum() == null) {
            return null;
        }

        Invoice invoice = new Invoice(createDTO.getInvoiceNum());
        invoice.initialize();
        return invoice;
    }
}
