package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService prService;
    
    private static final String VIEWS_PETS_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";


    @GetMapping("/create")
	public String initCreationForm( ModelMap model) {
		Product product = new Product();
        model.addAttribute("product", product);
        model.addAttribute("productType", prService.findAllProductTypes());
		return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
	}

    @PostMapping(path="/create")
	public String processCreationForm(@Valid Product product, BindingResult result, ModelMap model) {	
        String view = "welcome";
		if (result.hasErrors()) {
            model.addAttribute("product", product);
            model.addAttribute("productType", prService.findAllProductTypes());
			return VIEWS_PETS_CREATE_OR_UPDATE_FORM;
		}else {
            prService.save(product);
            model.addAttribute("message","Product succesfully created");
        }
        return view;
    }
}

