package com.ms.email.consumers;

import com.ms.email.dtos.EmailRecordDTO;
import com.ms.email.models.EmailModel;
import com.ms.email.services.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class EmailConsumer {
    final EmailService emailService;

    public EmailConsumer(EmailService emailService){
        this.emailService = emailService;
    }
    //Metodo que vai consumir as mensagens da fila (Queue)
    //                          Fila que será consumida
    @RabbitListener(queues = "${broker.queue.email.name}")
    //@Payload ele irá receber o corpo da mensagem
    public void listenEmailQueue(@Payload EmailRecordDTO emailRecordDTO){
        var emailModel = new EmailModel();
        BeanUtils.copyProperties(emailRecordDTO, emailModel);
        emailService.sendEmail(emailModel);
    }

}
