package sample.data.jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "professionals")
public class Professional extends User {
    @OneToMany(mappedBy = "professional")
    private List<RDV> appointments = new ArrayList<RDV>();
}
