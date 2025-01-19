package ma.xproce.clientservice.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="clients")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false, length = 100)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 100)
    private String prenom;

    @Column(name = "tel", length = 15)
    private String tel;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

}