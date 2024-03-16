package com.dosu04.memoWebApp.services;

import com.dosu04.memoWebApp.models.*;
import com.dosu04.memoWebApp.repositories.UserRepository;
import com.dosu04.memoWebApp.repositories.RoleRepository;
import com.dosu04.memoWebApp.repositories.DepartmentRepository;
import com.dosu04.memoWebApp.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final DepartmentRepository departmentRepository;
    private final FacultyRepository facultyRepository;
    private final PasswordEncoder passwordEncoder;



    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       DepartmentRepository departmentRepository, FacultyRepository facultyRepository,
                       PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.departmentRepository = departmentRepository;
        this.facultyRepository = facultyRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public void saveUser(User user) {
        if (user.getId() == null || !user.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }



    public long countUsers() {
        return userRepository.count();
    }

    public List<Role> findAllRoles() {
        return roleRepository.findAll();
    }

    public List<Department> findAllDepartments() {
        return departmentRepository.findAll();
    }

    public List<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }


//    public Optional<Object> findUserByUsername(String username) {
//    }



}
