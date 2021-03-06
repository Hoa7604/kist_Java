package pj.tour.entity;

public class TourEntity {
	private String tour_id;
	private String name_tour;
	private String location_start;
	private String time_start;
	private String date_start;
	private int mem_number;
	private int day_number;
	private int price_tour;
	
	public TourEntity() {
		super();
	}

	public TourEntity(String tour_id, String name_tour, String location_start, String time_start, String date_start,
			int mem_number, int day_number, int price_tour) {
		super();
		this.tour_id = tour_id;
		this.name_tour = name_tour;
		this.location_start = location_start;
		this.time_start = time_start;
		this.date_start = date_start;
		this.mem_number = mem_number;
		this.day_number = day_number;
		this.price_tour = price_tour;
	}
	
	public int getDay_number() {
		return day_number;
	}

	public void setDay_number(int day_number) {
		this.day_number = day_number;
	}

	public int getPrice_tour() {
		return price_tour;
	}

	public void setPrice_tour(int price_tour) {
		this.price_tour = price_tour;
	}

	public String getTour_id() {
		return tour_id;
	}
	public void setTour_id(String tour_id) {
		this.tour_id = tour_id;
	}
	public String getName_tour() {
		return name_tour;
	}
	public void setName_tour(String name_tour) {
		this.name_tour = name_tour;
	}
	public String getLocation_start() {
		return location_start;
	}
	public void setLocation_start(String location_start) {
		this.location_start = location_start;
	}
	public String getTime_start() {
		return time_start;
	}
	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}
	public String getDate_start() {
		return date_start;
	}
	public void setDate_start(String date_start) {
		this.date_start = date_start;
	}
	public int getMem_number() {
		return mem_number;
	}
	public void setMem_number(int mem_number) {
		this.mem_number = mem_number;
	} 
}
