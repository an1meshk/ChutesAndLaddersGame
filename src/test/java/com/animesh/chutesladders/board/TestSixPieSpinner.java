package com.animesh.chutesladders.board;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * Created by Animesh Kumar on 12-08-2018.
 */
public class TestSixPieSpinner {

    @Test
    public void spinOutcomeBoundaryTest() {
        SixPieSpinner spinner = new SixPieSpinner();

        for(int i=0; i<60; i++){
            int result = spinner.spin();

            assertThat(result,
                    anyOf(lessThanOrEqualTo(6), greaterThanOrEqualTo(1)));
        }
    }


}
