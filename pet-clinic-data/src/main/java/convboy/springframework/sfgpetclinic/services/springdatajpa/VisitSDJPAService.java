package convboy.springframework.sfgpetclinic.services.springdatajpa;

import convboy.springframework.sfgpetclinic.model.Visit;
import convboy.springframework.sfgpetclinic.repositories.VisitRepository;
import convboy.springframework.sfgpetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;


@Service
@Profile("springdatajpa")
public class VisitSDJPAService implements VisitService {

    private final VisitRepository visitRepo;

    public VisitSDJPAService(VisitRepository visitRepo) {
        this.visitRepo = visitRepo;
    }


    @Override
    public Set<Visit> findAll() {
        Set<Visit> visits = new HashSet<>();
        visitRepo.findAll().forEach(visits::add);
        return visits;
    }

    @Override
    public Visit findById(Long aLong) {
        return visitRepo.findById(aLong).orElse(null);
    }

    @Override
    public Visit save(Visit obj) {
        return visitRepo.save(obj);
    }

    @Override
    public void delete(Visit obj) {
        visitRepo.delete(obj);

    }

    @Override
    public void deleteById(Long aLong) {
        visitRepo.deleteById(aLong);
    }
}
