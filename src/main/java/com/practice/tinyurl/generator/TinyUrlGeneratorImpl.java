package com.practice.tinyurl.generator;

import com.practice.tinyurl.util.Base62Encoder;
import com.practice.tinyurl.util.TinyUrlServiceUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TinyUrlGeneratorImpl implements TinyUrlGenerator {

    // TODO support of different types of tinyurl generators can be added

    // TODO how to make it confiugrable
    private int numberLength = 9;

    /*public TinyUrlGeneratorImpl(int numberLength)
    {
        this.numberLength = numberLength;
    }*/

    @Override
    public String generateUrl() {
        int randomNumber = TinyUrlServiceUtils.generateRandomNumberOfLength(numberLength);
        log.debug("Random number generated : " + randomNumber);
        // TODO can me made object call instead of static method call
        String hash = Base62Encoder.generateHashForNumber(randomNumber);
        log.debug("Hash generated : " + hash + " for random number : " + randomNumber);
        return TinyUrlServiceUtils.SHORT_URL_PREFIX + hash;
    }
}
