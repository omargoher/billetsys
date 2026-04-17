/*
 * Eclipse Public License - v 2.0
 *
 *   THE ACCOMPANYING PROGRAM IS PROVIDED UNDER THE TERMS OF THIS ECLIPSE
 *   PUBLIC LICENSE ("AGREEMENT"). ANY USE, REPRODUCTION OR DISTRIBUTION
 *   OF THE PROGRAM CONSTITUTES RECIPIENT'S ACCEPTANCE OF THIS AGREEMENT.
 */
package ai.mnemosyne_systems.model.event;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "events", indexes = { @Index(name = "idx_events_company_id", columnList = "company_id"),
        @Index(name = "idx_events_key_type_created_at", columnList = "event_key,event_type,created_at") })
public class Event extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "event_type")
    public Long eventType;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDateTime createdAt;

    /**
     * Loose foreign key. Its target is determined by {@link #eventType}; it is a bigint in the database rather than a
     * JPA relationship on purpose.
     */
    @Column(name = "event_key")
    public Long key;

    @Column(name = "company_id")
    public Long companyId;

    @Column(name = "user_id")
    public Long userId;

    @Column(name = "event_value")
    public String eventValue;
}
