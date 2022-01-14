package org.springframework.samples.petclinic.product;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component
public class ProductTypeFormatter implements Formatter<ProductType>{

    private final ProductService prService;

	@Autowired
	public ProductTypeFormatter(ProductService prService) {
		this.prService = prService;
	}
    @Override
    public String print(ProductType object, Locale locale) {
        return object.getName();
    }

    @Override
    public ProductType parse(String text, Locale locale) throws ParseException {
        List<ProductType> findProductTypes = this.prService.findAllProductTypes();
		for (ProductType type : findProductTypes) {
			if (type.getName().equals(text)) {
				return type;
			}
		}
		throw new ParseException("type not found: " + text, 0);
	}
}
