package repositories;

import org.springframework.data.repository.CrudRepository;

import com.losolved.booking.model.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long> {

}
