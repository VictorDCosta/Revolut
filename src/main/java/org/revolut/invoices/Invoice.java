package org.revolut.invoices;
import lombok.Getter;

@Getter
public class Invoice {
    private String invoiceNum;

    public Invoice(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public void initialize() {
        if(this.invoiceNum.length() < 2) {
            return;
        }
        this.invoiceNum = this.invoiceNum.substring(2);
    }
}
