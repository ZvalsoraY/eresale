package first.resale.service.implementation;

import first.resale.repository.ProductRepository;
import first.resale.repository.RoleRepository;
import first.resale.repository.UserRepository;
import first.resale.service.ProductService;
import first.resale.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl  implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository){
        this.roleRepository = roleRepository;
    }

}
