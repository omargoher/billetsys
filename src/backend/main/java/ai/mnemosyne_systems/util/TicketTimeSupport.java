/*
 * Eclipse Public License - v 2.0
 *
 *   THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE
 *   PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION
 *   OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.
 */

package ai.mnemosyne_systems.util;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;

/** Calculates elapsed ticket time on the instant timeline across DST changes. */
public final class TicketTimeSupport {

    private TicketTimeSupport() {
    }

    public static long elapsedMinutes(LocalDateTime from, LocalDateTime to) {
        return Math.max(0, minutesBetween(from, to, ZoneId.systemDefault()));
    }

    static long elapsedMinutes(LocalDateTime from, LocalDateTime to, ZoneId zone) {
        return Math.max(0, minutesBetween(from, to, zone));
    }

    public static long minutesBetween(LocalDateTime from, LocalDateTime to) {
        return minutesBetween(from, to, ZoneId.systemDefault());
    }

    private static long minutesBetween(LocalDateTime from, LocalDateTime to, ZoneId zone) {
        if (from == null || to == null) {
            return 0;
        }
        return Duration.between(from.atZone(zone).toInstant(), to.atZone(zone).toInstant()).toMinutes();
    }
}
