package de.watchmywatch.repository.storage.api;

import de.watchmywatch.model.OrderManagment.Shoppingcart;
import de.watchmywatch.model.WatchManagment.Watch;
import de.watchmywatch.repository.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/api")
public class ShoppingcartController {
    @Autowired
    public ShoppingcartRepository shoppingcartRepository;
    @Autowired
    public WatchRepository watchRepository;

    // GET /api/shoppingcarts returns all shoppingcarts
    @GetMapping(path = "/shoppingcarts")
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    Iterable<Shoppingcart> getAllShoppingcarts() {
        return shoppingcartRepository.findAll();
    }

    // GET /api/shoppingcarts/:id returns shoppingcart with id
    @GetMapping(value = "/shoppingcarts/{shoppingcartId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Shoppingcart getOneShoppingcart(@PathVariable Integer shoppingcartId) {
        return shoppingcartRepository.findById(shoppingcartId)
                .orElseThrow(() -> new NotFoundException("shoppingcart", shoppingcartId));
    }

    // POST /api/shoppingcarts creates a shoppingcart in the database and returns "Saved"
    @PostMapping(path = "/shoppingcarts") // Map ONLY POST Requests
    public @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    Shoppingcart addNewShoppingcart(Shoppingcart shoppingcart) {
        return shoppingcartRepository.save(shoppingcart);
    }

    // PUT /api/shoppingcarts/:id updates the shoppingcart with the id
    @PutMapping("/shoppingcarts/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Shoppingcart updateShoppingcart(@PathVariable Integer id, @RequestBody Shoppingcart newShoppingcart) {
        return shoppingcartRepository.findById(id)
                .map(shoppingcart -> {
                    shoppingcart.setItems(newShoppingcart.getItems());
                    shoppingcart.calcTotal();
                    return shoppingcartRepository.save(shoppingcart);
                })
                .orElseGet(() -> {
                    newShoppingcart.setId(id);
                    return shoppingcartRepository.save(newShoppingcart);
                });
    }

    // DELETE /api/shoppingcarts/:id deletes the shoppingcart with id and returns "Deleted"
    @DeleteMapping(path = "/shoppingcarts/{id}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void updateShoppingcart(@PathVariable Integer id) {
        shoppingcartRepository.deleteById(id);
    }


    @PostMapping(path = "/shoppingcarts/{id}/addWatch/{watchId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Shoppingcart addWatchToShoppingcart(@PathVariable Integer id, @PathVariable Integer watchId) {
        Optional<Watch> watch = watchRepository.findById(watchId);
        Optional<Shoppingcart> shoppingcart = shoppingcartRepository.findById(id);
        shoppingcart.get().addWatch(watch.get());
        return shoppingcartRepository.save(shoppingcart.get());
    }

    @PostMapping(path = "/shoppingcarts/{id}/removeWatch/{watchId}")
    public @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    Shoppingcart removeWatchFromShoppingcart(@PathVariable Integer id, @PathVariable Integer watchId) {
        Optional<Watch> watch = watchRepository.findById(watchId);
        Optional<Shoppingcart> shoppingcart = shoppingcartRepository.findById(id);
        shoppingcart.get().removeWatch(watch.get());
        return shoppingcartRepository.save(shoppingcart.get());
    }

}
