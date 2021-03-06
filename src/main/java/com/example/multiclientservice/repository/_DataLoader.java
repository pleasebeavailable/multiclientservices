package com.example.multiclientservice.repository;

import com.example.multiclientservice.repository.model.Category;
import com.example.multiclientservice.repository.model.Privilege;
import com.example.multiclientservice.repository.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Component
public class _DataLoader implements ApplicationRunner {
    private RoleRepository roleRepository;
    private PrivilegeRepository privilegeRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public _DataLoader(RoleRepository roleRepository, PrivilegeRepository privilegeRepository, CategoryRepository categoryRepository) {
        this.roleRepository = roleRepository;
        this.privilegeRepository = privilegeRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadData();
    }

    private void loadData() {
        Privilege readPrivilege =
                createPrivilegeIfNotFound("READ_PRIVILEGE");
        Privilege writePrivilege
                = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

        List<Privilege> adminPrivileges = Arrays.asList(
                readPrivilege, writePrivilege);
        createRoleIfNotFound("ROLE_MERCHANT", adminPrivileges);
        createRoleIfNotFound("ROLE_CUSTOMER", adminPrivileges);
        createCategories();
    }

    @Transactional
    public void createCategories() {
        String name = "category ";

        for (int i = 1; i < 6; i++) {
            Category category = new Category();
            category.setName(name + i);
            categoryRepository.save(category);
        }
    }

    @Transactional
    public Privilege createPrivilegeIfNotFound(String name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    public Role createRoleIfNotFound(
            String name, Collection<Privilege> privileges) {

        Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }
}
