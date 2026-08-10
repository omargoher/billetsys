/*
 * Eclipse Public License - v 2.0
 *
 *   THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE
 *   PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION
 *   OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.
 */

package ai.mnemosyne_systems.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TicketTimeSupportTest {

    private static final ZoneId NEW_YORK = ZoneId.of("America/New_York");

    @Test
    void calculatesActualElapsedTimeAcrossDaylightSavingTimeStart() {
        Assertions.assertEquals(60, TicketTimeSupport.elapsedMinutes(LocalDateTime.of(2026, 3, 8, 1, 30),
                LocalDateTime.of(2026, 3, 8, 3, 30), NEW_YORK));
    }

    @Test
    void calculatesActualElapsedTimeAcrossStandardTimeStart() {
        Assertions.assertEquals(180, TicketTimeSupport.elapsedMinutes(LocalDateTime.of(2026, 11, 1, 0, 30),
                LocalDateTime.of(2026, 11, 1, 2, 30), NEW_YORK));
    }
}
