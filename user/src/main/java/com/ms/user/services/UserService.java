package com.ms.user.services;

import com.ms.user.models.UserModel;
import com.ms.user.producers.UserProducer;
import com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;
    //segundo: Do mesmo modo uso o construtor do Service para acessar o repository e salvar o
    // Usuário nele utilizando o metodo do JPA
    public UserService(UserRepository userRepository,
                       UserProducer userProducer){
        this.userProducer = userProducer;
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel){
       userModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userModel);
        return userModel;
    }


}
