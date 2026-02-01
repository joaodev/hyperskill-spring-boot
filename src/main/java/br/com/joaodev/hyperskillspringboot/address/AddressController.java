package br.com.joaodev.hyperskillspringboot.address;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class AddressController {

    final private ConcurrentMap<String, String>  addressBook = new ConcurrentHashMap<>();

    @GetMapping("/addresses")
    public ConcurrentMap<String, String> getAddresses() {
        return addressBook;
    }

    @GetMapping("/addresses/{name}")
    public String getAddress(@PathVariable String name) {
        return addressBook.get(name);
    }

    @PostMapping("/addresses")
    public void postAddress(@RequestParam String name, @RequestParam String address) {
        addressBook.put(name, address);
    }

    @DeleteMapping("/addresses/{name}")
    public String deleteAddress(@PathVariable String name) {
        addressBook.remove(name);
        return name + " removed from address book";
    }
}
