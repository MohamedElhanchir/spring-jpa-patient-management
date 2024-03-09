package ma.enset.jpaap.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
    * @Column(name = "NAME", length = 50) : permet de spécifier le nom de la colonne dans la base de données
    * ainsi que la taille de la colonne
     */
   //@Column(name = "NAME", length = 50)
    @Column(length = 50)
    private String name;
    /*
    * @Temporal(TemporalType.DATE) : permet de spécifier le type de la colonne dans la base de données
     */
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    private boolean malade;
    private int score;

}
