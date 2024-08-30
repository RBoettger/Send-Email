package com.ms.email.dtos;

import java.util.UUID;

public record EmailRecordDTO(UUID idUser, String emailTo, String subject, String text) {
}
