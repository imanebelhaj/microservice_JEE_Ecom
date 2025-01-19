package ma.xproce.tp1jee.controllers;

import ch.qos.logback.core.testUtil.DelayingListAppender;
import ma.xproce.tp1jee.models.Produit;
import ma.xproce.tp1jee.repositories.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/products/")
public class ProduitController {
    @Autowired
    ProduitRepository produitRepository;

    @PostMapping("/add")
    public ResponseEntity<Produit> addProduct(@RequestBody Produit produit){
        try{
            produitRepository.save(produit);
            return new ResponseEntity<>(produit, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }  // try catch exc status created
    }

    @GetMapping("/productDetails/{id}")
    public ResponseEntity<Produit> productDetails(@PathVariable("id") Long id){
        Optional<Produit> p = produitRepository.findById(id);
        if(p.isPresent()){
            Produit produit=p.get();
            return new ResponseEntity<>(produit,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } // is present

    @GetMapping("/productList")
    public ResponseEntity<List<Produit>> productList(){
        List<Produit> p = produitRepository.findAll();
        return new ResponseEntity<>(p,HttpStatus.OK);
    }
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") Long id){
        try{
            produitRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/emptylist")
    public ResponseEntity<HttpStatus> emptyList() {
        try {
            produitRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //modifier
    @PutMapping("/{id}")
    public ResponseEntity<Produit> modifier(@PathVariable("id") int id, @RequestBody Produit produit) {

        if(produitRepository.save(produit)!=null)
        {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





}
