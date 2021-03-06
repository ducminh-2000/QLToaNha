package com.example.qltoanha.controllers;

import com.example.qltoanha.models.entity.NhanVienToaNha;
import com.example.qltoanha.repository.NVToaNhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/nvtoanha",produces = "application/json")
@CrossOrigin("*")
public class NhanVienToaNhaController {
    @Autowired
    private NVToaNhaRepository repo;

    @GetMapping
    public List<NhanVienToaNha> getAll(){
        return (List<NhanVienToaNha>) repo.findAll();
    }
    
    @GetMapping("/index={i}")
    public List<NhanVienToaNha> getPage(@PathVariable("i") int index){
        return (List<NhanVienToaNha>) repo.findAllInPage(index);
    }
    
    @GetMapping("/toanha={i}")
    public List<NhanVienToaNha> getAllByToaNha(@PathVariable("i") int index){
        return (List<NhanVienToaNha>) repo.findAllByToaNha(index);
    }
    
    @GetMapping("/toanha={i}/index={ii}")
    public List<NhanVienToaNha> getAllByToaNha(@PathVariable("i") int id,@PathVariable("ii") int index){
        return (List<NhanVienToaNha>) repo.findAllInPage(id, index);
    }
    
    @GetMapping("/search={i}")
    public List<NhanVienToaNha> search(@PathVariable("i") String index){
        return (List<NhanVienToaNha>) repo.findAllByTenContainingIgnoreCase(index);
    }
    
    @GetMapping("/{id}")
    public NhanVienToaNha getById(@PathVariable("id") int id){
        Optional<NhanVienToaNha> x = repo.findById(id);
        if(x.isPresent()){
            return  x.get();
        }
        return null;
    }
    @PostMapping
    public NhanVienToaNha create(@RequestBody NhanVienToaNha x){
        return repo.save(x);
    }
    @PutMapping("/{id}")
    public NhanVienToaNha update(@RequestBody NhanVienToaNha ph, @PathVariable("id") int id){
        Optional<NhanVienToaNha> p = repo.findById(id);
        if(p.isPresent()){
            NhanVienToaNha x = p.get();
            x.setTen(ph.getTen());
            x.setBac(ph.getBac());
            x.setDiaChi(ph.getDiaChi());
            x.setNgaySinh(ph.getNgaySinh());
            x.setSdt(ph.getSdt());
            x.setPhongBan(ph.getPhongBan());
            return repo.save(x);
        }
        return null;
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") int id){
        repo.deleteById(id);
    }
}
