package shein.dmitriy.ntiteam.entitys;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tplanet")
@Data
public class Planet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planet_id")
    private int planetId;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "governor_id")
    private Governor governor;
}
