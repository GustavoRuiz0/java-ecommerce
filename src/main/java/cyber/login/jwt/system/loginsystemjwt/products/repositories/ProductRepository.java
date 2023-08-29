package cyber.login.jwt.system.loginsystemjwt.products.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import cyber.login.jwt.system.loginsystemjwt.products.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, UUID>{
    
}
