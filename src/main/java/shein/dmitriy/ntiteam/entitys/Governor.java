package shein.dmitriy.ntiteam.entitys;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "tgovernor")
@Data
public class Governor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "governor_id")
    private int governorId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private short age;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "governor")
    private List<Planet> planets;


}
