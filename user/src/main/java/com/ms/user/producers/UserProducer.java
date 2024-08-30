package com.ms.user.producers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.user.dtos.EmailDTO;
import com.ms.user.models.UserModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    final RabbitTemplate rabbitTemplate;

    public  UserProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value("${broker.queue.email.name}")
    private String routingKey;

    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    public void publishMessageEmail(UserModel userModel){
        var email = new EmailDTO();
        email.setIdUser(userModel.getIdUser());
        email.setEmailTo(userModel.getEmail());
        email.setSubject("Usuário cadastrado com sucesso!");
        email.setText("Bem-vindo! " +userModel.getName()+ "\nAproveite os estudos e divirta-se!");

        rabbitTemplate.convertAndSend("", routingKey, email);
    }

}
