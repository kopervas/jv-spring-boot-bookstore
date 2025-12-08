package com.bookstore;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = {
        "jwt.secret=hellomates1234567890asdfghjklwertyuisdsdsdsdsd",
        "jwt.expiration=300000",
        "server.servlet.context-path=/api"
})
class BookstoreApplicationTests {

    @Test
    void contextLoads() {
    }

}
