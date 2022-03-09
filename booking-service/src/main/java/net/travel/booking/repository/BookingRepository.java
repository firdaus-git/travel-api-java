package net.travel.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.travel.booking.entity.Booking;


public interface BookingRepository extends JpaRepository<Booking, Long>{

}
