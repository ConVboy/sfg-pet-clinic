package convboy.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name ="types")
public class PetType extends BaseEntity {

    @Column(name ="name")
    private String name;

}
