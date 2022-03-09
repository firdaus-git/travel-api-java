package net.travel.booking.responseVO;

import java.util.Date;


public class BookingResponseVO {

	private Long id;
	
	private Long userId;
	
	private Integer itineraryId;
	
	private Date date;
	
	private String customerName;
	
	private String phoneNumber;
	
	private String seatNumber;

	private ItineraryResponseVO itineraryVO;
	
	public BookingResponseVO() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Integer getItineraryId() {
		return itineraryId;
	}

	public void setItineraryId(Integer itineraryId) {
		this.itineraryId = itineraryId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public ItineraryResponseVO getItineraryVO() {
		return itineraryVO;
	}

	public void setItineraryVO(ItineraryResponseVO itineraryVO) {
		this.itineraryVO = itineraryVO;
	}
	
	
}
