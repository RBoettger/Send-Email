package com.ms.email.configs;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfig {


    //Conecto ao broker e dou acesso a propriedade definida (lembrando que o endereço tem que ser o mesmo do app.properties)
    @Value("${broker.queue.email.name}")
    //a propriedade definida é um atributo do tipo String
    private String queue;

    //Bean deixa explicito para o Spring que a Queue será iniciada quando necessário
    @Bean
    public Queue queue() {
        //metodo que instancia uma nova queueu com o nome da queue que será criada. no caso o nome é "queue".
        //"true" quer dizer que ela é duravel, ou seja se o broker cair e voltar, a fila será preservada. true/false
        return new Queue(queue, true);
    }

    @Bean
    //Vamos receber o corpo da mensagem em JSON e converter para o emailRecordsDTO
    public Jackson2JsonMessageConverter messageConverter(){
        ObjectMapper objectMapper = new ObjectMapper();
        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
