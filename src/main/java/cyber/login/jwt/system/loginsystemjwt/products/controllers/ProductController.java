package cyber.login.jwt.system.loginsystemjwt.products.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import cyber.login.jwt.system.loginsystemjwt.products.dtos.ProductInsertDto;
import cyber.login.jwt.system.loginsystemjwt.products.models.ProductModel;
import cyber.login.jwt.system.loginsystemjwt.products.services.ProductService;



@RestController
@RequestMapping("products")
public class ProductController {

    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(ProductInsertDto productInsertDto) {
        return productService.createProduct(productInsertDto);
    }



}

  

