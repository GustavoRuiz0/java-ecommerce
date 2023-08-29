package cyber.login.jwt.system.loginsystemjwt.products.services;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cyber.login.jwt.system.loginsystemjwt.products.dtos.ProductInsertDto;
import cyber.login.jwt.system.loginsystemjwt.products.models.ProductModel;
import cyber.login.jwt.system.loginsystemjwt.products.repositories.ProductRepository;

@Service
public class ProductService {

    private static final String UPLOAD_DIR = "/home/cyber/Documents/Java/ecommerce/spring-boot-3-spring-security6-jwt-token/src/main/resources/static/images/img-uploads"; // Diretório onde as imagens serão salvas


    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    public ResponseEntity<Object> createProduct(ProductInsertDto productInsertDto) {
        try {
            String imagePath = saveImage(productInsertDto.file());

            var newProduct = new ProductModel(productInsertDto.name(), productInsertDto.description(), imagePath);
            productRepository.save(newProduct); 

            return ResponseEntity.ok("Produto criado com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao criar o produto.");
        }
    }




    private String saveImage(MultipartFile file) throws IOException {
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Path.of(UPLOAD_DIR, fileName);

        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        return filePath.toString();
    }

  
}