package convboy.springframework.sfgpetclinic.services.springdatajpa;

import convboy.springframework.sfgpetclinic.model.Specialty;
import convboy.springframework.sfgpetclinic.repositories.SpecialtyRepository;
import convboy.springframework.sfgpetclinic.services.SpecialtyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class SpecialtySDJPAService implements SpecialtyService {

    private final SpecialtyRepository specialtyRepo;

    public SpecialtySDJPAService(SpecialtyRepository specialtyRepo) {
        this.specialtyRepo = specialtyRepo;
    }

    @Override
    public Set<Specialty> findAll() {
        Set<Specialty> specialties = new HashSet<>();
        specialtyRepo.findAll().forEach(specialties::add);
        return specialties;
    }

    @Override
    public Specialty findById(Long aLong) {
        return specialtyRepo.findById(aLong).orElse(null);
    }

    @Override
    public Specialty save(Specialty obj) {
        return specialtyRepo.save(obj);
    }

    @Override
    public void delete(Specialty obj) {
        specialtyRepo.delete(obj);
    }

    @Override
    public void deleteById(Long aLong) {
        specialtyRepo.deleteById(aLong);
    }
}
