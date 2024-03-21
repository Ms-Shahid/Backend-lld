package org.backend.session.lld2.designpatterns.prototype.efficientInvoicegeneration;

public interface InvoicePrototypeRegistry {

    void addInvoice(Invoice invoice);

    Invoice getInvoice(InvoiceType invoiceType);

    Invoice clone(InvoiceType invoiceType);
}
