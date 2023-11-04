package com.scaler.adminmanagementservice.helper;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ConvertTime {
    public static long localDateTimeToLong(LocalDateTime time) {
        ZonedDateTime zdt = time.atZone(ZoneId.systemDefault());
        Instant instant = zdt.toInstant();

        return instant.toEpochMilli();
    }
}
