package org.backend.session.lld2.designpatterns.prototype.efficientInvoicegeneration;

import java.util.HashMap;
import java.util.Map;

public class InvoicePrototypeRegistryImp implements InvoicePrototypeRegistry{

    Map<InvoiceType, Invoice> invoiceRegistry = new HashMap<>();

    @Override
    public void addInvoice(Invoice invoice) {
        invoiceRegistry.put( invoice.getType(), invoice);
    }

    @Override
    public Invoice getInvoice(InvoiceType invoiceType) {
        return invoiceRegistry.get(invoiceType);
    }

    @Override
    public Invoice clone(InvoiceType invoiceType) {

        Invoice prototype = invoiceRegistry.get(invoiceType);
        return prototype != null ? prototype.clone() : null;
    }
}
