package sample.data.jpa.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "rdv")
public class RDV {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date start_time;

    private String name;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Professional professional;

    private boolean isReserved;
}
