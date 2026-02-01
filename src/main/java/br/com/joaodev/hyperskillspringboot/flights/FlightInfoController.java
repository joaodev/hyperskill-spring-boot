package br.com.joaodev.hyperskillspringboot.flights;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class FlightInfoController {

    private final List<FlightInfo> flightInfoList = new ArrayList<>();

    public FlightInfoController() {
        flightInfoList.add(new FlightInfo(1, "Lisbon", "Porto", "A10"));
        flightInfoList.add(new FlightInfo(2, "Porto", "Lisbon", "A20"));
        flightInfoList.add(new FlightInfo(3, "Porto", "Amsterdam", "A30"));
        flightInfoList.add(new FlightInfo(4, "Amsterdam", "Porto", "A40"));
        flightInfoList.add(new FlightInfo(5, "Amsterdam", "Lisbon", "A50"));
    }

    @GetMapping("/flights")
    public List<FlightInfo> getFlights() {
        return flightInfoList;
    }

    @GetMapping("/flights/{id}")
    public FlightInfo getFlight(@PathVariable int id) {
        for (FlightInfo flightInfo : flightInfoList) {
            if (flightInfo.getId() == id) {
                if (Objects.equals(flightInfo.getFrom(), "Amsterdam")) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amsterdam is not a valid origin");
                } else {
                    return flightInfo;
                }
            }
        }
        throw new FlightNotFoundException("Flight with id " + id + " not found");
    }
}
