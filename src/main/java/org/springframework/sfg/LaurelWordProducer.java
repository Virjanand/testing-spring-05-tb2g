package org.springframework.sfg;

import org.springframework.stereotype.Component;

@Component
public class LaurelWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
