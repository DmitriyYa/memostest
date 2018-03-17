package kz.yakovlev.memos.test.helpers;

import java.util.UUID;

public class GenerateUUID {
    private String uuid;

    public String getUuid() {
        return uuid = UUID.randomUUID().toString();
    }
}
