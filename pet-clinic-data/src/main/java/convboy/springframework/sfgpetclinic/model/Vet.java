package convboy.springframework.sfgpetclinic.model;

import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialites() {
        return specialties;
    }

    public void setSpecialites(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
