package org.springframework.sfg;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

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
