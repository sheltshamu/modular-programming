package zw.co.afrosoft.api.lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zw.co.afrosoft.domain.lecturer.Lecturer;
import zw.co.afrosoft.service.lecturer.LecturerService;

import java.util.List;

@RestController
@RequestMapping("/lecturer")
public class LecturerController {

    private final LecturerService lecturerService;

    @Autowired
    public LecturerController(LecturerService lecturerService) {
        this.lecturerService = lecturerService;
    }

    @GetMapping
    public List<Lecturer> listAll(){
        return lecturerService.listAll();
    }

    @PostMapping
    public void add(@RequestBody Lecturer lecturer) {
        lecturerService.save(lecturer);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable Long id) {
        lecturerService.remove(id);
    }

    @PutMapping("/{id}")
    public Lecturer update(@RequestBody Lecturer lecturer, @PathVariable Long id) {
        Lecturer existingLecturer = lecturerService.findById(id);
        existingLecturer.setTitle(lecturer.getTitle());
        existingLecturer.setFirstname(lecturer.getFirstname());
        existingLecturer.setLastname(lecturer.getLastname());
        existingLecturer.setDepartment(lecturer.getDepartment());
        lecturerService.save(existingLecturer);
        return existingLecturer;
    }

    @GetMapping("/{id}")
    public Lecturer findById(@PathVariable Long id) {
        return lecturerService.findById(id);
    }

}
