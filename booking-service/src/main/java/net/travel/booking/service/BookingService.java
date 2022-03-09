package net.travel.booking.service;

import java.util.List;

import net.travel.booking.requestVO.BookingRequestVO;
import net.travel.common.model.APIResponse;

public interface BookingService {	
	APIResponse<?> create(BookingRequestVO requestVO);
	APIResponse<?> edit(BookingRequestVO requestVO);
	APIResponse<?> delete(Long id);
	APIResponse<List<?>> getAll();
	APIResponse<?> getById(Long id);
}
