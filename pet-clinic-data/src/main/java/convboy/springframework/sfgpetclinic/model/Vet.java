package convboy.springframework.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> specialties = new HashSet<>();

    public Set<Specialty> getSpecialites() {
        return specialties;
    }

    public void setSpecialites(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
