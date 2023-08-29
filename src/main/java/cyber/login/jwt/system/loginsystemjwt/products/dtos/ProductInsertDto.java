package cyber.login.jwt.system.loginsystemjwt.products.dtos;

import org.springframework.web.multipart.MultipartFile;

public record ProductInsertDto(String name, String description, MultipartFile file) {
    
}
