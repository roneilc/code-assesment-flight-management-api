import org.springframework.stereotype.Service;

import com.jb.flightmanagement.models.Flight;
import com.jb.flightmanagement.repository.FlightRepository;

@Service
public class FlightService {

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public Flight createFlight() {
        Flight flight = new Flight();

        return flightRepository.save(flight);
    }

    public Flight cancelFlight(int id) {

        return flightRepository.delete(id);
    }
}
