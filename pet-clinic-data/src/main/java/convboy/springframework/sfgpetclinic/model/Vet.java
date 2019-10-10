package convboy.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> specialites;

    public Set<Specialty> getSpecialites() {
        return specialites;
    }

    public void setSpecialites(Set<Specialty> specialites) {
        this.specialites = specialites;
    }
}
