package org.revolut.invoices;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceCreateDTO implements Serializable {

    private String invoiceNum;
    private String clientName;
}
