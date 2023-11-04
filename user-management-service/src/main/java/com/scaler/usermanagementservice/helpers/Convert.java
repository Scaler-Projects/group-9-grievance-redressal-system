package com.scaler.usermanagementservice.helpers;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Convert {
    public static Long localDateTimeToLong(LocalDateTime time) {
        ZonedDateTime zdt = time.atZone(ZoneId.systemDefault());
        Instant instant = zdt.toInstant();

        return instant.toEpochMilli();
    }
}
