package net.travel.booking.responseVO;

public class ItineraryResponseVO {

	private Long id;
	
	private Long companyId;
	
	private Long departureId;
	
	private String departureTime;
	
	private String arrivalId;
	
	private String arrivalTime;
	
	private Double price;
	
	private String description;

    private BookingResponseVO bookingVO;
	
	public ItineraryResponseVO() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	public Long getDepartureId() {
		return departureId;
	}

	public void setDepartureId(Long departureId) {
		this.departureId = departureId;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public String getArrivalId() {
		return arrivalId;
	}

	public void setArrivalId(String arrivalId) {
		this.arrivalId = arrivalId;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BookingResponseVO getBookingVO() {
		return bookingVO;
	}

	public void setBookingVO(BookingResponseVO bookingVO) {
		this.bookingVO = bookingVO;
	}
}
