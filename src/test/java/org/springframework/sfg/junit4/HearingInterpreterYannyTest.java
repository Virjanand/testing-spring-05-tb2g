package org.springframework.sfg.junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.sfg.BaseConfig;
import org.springframework.sfg.HearingInterpreter;
import org.springframework.sfg.YannyConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@ActiveProfiles("base-test")
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BaseConfig.class, YannyConfig.class})
public class HearingInterpreterYannyTest {

    @Autowired
    private HearingInterpreter hearingInterpreter;

    @Test
    public void whatIHeard() {
        String whatIHeard = hearingInterpreter.whatIHeard();

        assertEquals("Yanny", whatIHeard);
    }
}
