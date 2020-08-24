package org.springframework.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ActiveProfiles("laurel-property")
@SpringJUnitConfig(classes = HearingInterpreterLaurelPropertySourceTest.TestConfig.class)
@TestPropertySource("classpath:laurel.properties")
public class HearingInterpreterLaurelPropertySourceTest {

    @Configuration
    @ComponentScan("org.springframework.sfg")
    static class TestConfig {
    }

    @Autowired
    private HearingInterpreter hearingInterpreter;

    @Test
    void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();

        assertEquals("LaureL", word);
    }
}
