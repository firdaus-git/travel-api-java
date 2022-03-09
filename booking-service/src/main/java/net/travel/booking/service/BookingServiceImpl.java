package net.travel.booking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import net.travel.booking.entity.Booking;
import net.travel.booking.repository.BookingRepository;
import net.travel.booking.requestVO.BookingRequestVO;
import net.travel.booking.responseVO.BookingResponseVO;
import net.travel.common.model.APIResponse;
import net.travel.common.util.MapperUtil;

public class BookingServiceImpl {
	
	@Autowired
    private BookingRepository bookingRepository;
	
	
	public APIResponse<?> create(BookingRequestVO requestVO) {
		Booking booking;
		BookingResponseVO responseVO = null;
		try {
			
			Booking entity = MapperUtil.map(requestVO, Booking.class);	
			
			booking = bookingRepository.save(entity);
			
			responseVO = MapperUtil.map(booking, BookingResponseVO.class);
			
			return APIResponse.general("successfully created", responseVO);
			
		}catch (Exception e){
			
			return APIResponse.error("Failed created", responseVO);
		}

	}
	
	public APIResponse<?> edit(BookingRequestVO requestVO) {
		Booking booking;
		BookingResponseVO responseVO = null;
		try {
			Optional<Booking> data = bookingRepository.findById(requestVO.getId());
			
			if (data.isPresent()) {
				
				Booking entity = MapperUtil.map(requestVO, Booking.class);	
				
				booking = bookingRepository.save(entity);
				
				responseVO = MapperUtil.map(booking, BookingResponseVO.class);

				return APIResponse.general("successfully update", responseVO);
			}
			
			return APIResponse.error("Not found ", responseVO);
			
		}catch (Exception e){
			
			return APIResponse.error("Failed update", responseVO);
		}
		
	}
	
	public APIResponse<?> delete(Long id) {
		Booking booking;
		BookingResponseVO responseVO = null;
		try {
			
			booking = bookingRepository.getById(id);
			
			bookingRepository.delete(booking);
			
			responseVO = MapperUtil.map(booking, BookingResponseVO.class);

			return APIResponse.general("successfully delete", responseVO);
		}catch (Exception e){
			
			return APIResponse.error("Failed delete", id);
		}
	}
	
	public APIResponse<List<?>> getAll() {	
		
		List<BookingResponseVO> listResponseVO = new ArrayList<>();
		try {
			List<Booking> listBooking = bookingRepository.findAll();
			
			listResponseVO = MapperUtil.mapAll(listBooking, BookingResponseVO.class);
			
			return APIResponse.general("Retrieve all", listResponseVO, listResponseVO.size());
		}catch (Exception e){
			
			return APIResponse.error("Failed Retrieve all", listResponseVO);
		}
	}
	
	public APIResponse<?> getById(Long id) {
		BookingResponseVO responseVO = null;
		try {
			
			Optional<Booking> booking = bookingRepository.findById(id);
			
			if (booking.isPresent()) {

				responseVO = MapperUtil.map(booking.get(), BookingResponseVO.class);
				
				return APIResponse.general("Retrieve detail", responseVO);
			}
			
			return APIResponse.general("Not found", null);
			
		}catch (Exception e){
			
			return APIResponse.error("Failed get detail", responseVO);
		}
	}
}
