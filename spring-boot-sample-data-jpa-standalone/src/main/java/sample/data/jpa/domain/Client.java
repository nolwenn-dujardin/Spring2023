package sample.data.jpa.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "clients")
public class Client extends User{
    @OneToMany(mappedBy = "client")
    private List<RDV> appointments = new ArrayList<RDV>();
}
