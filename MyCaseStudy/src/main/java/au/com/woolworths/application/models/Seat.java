package au.com.woolworths.application.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Seat{

	
	int blockNo;
	int rowNo;
	int columnNo;
	int passengerNo;
	int seatTypePriority;
	String seatTypeName;
	
	public Seat() {
	}
	
	public Seat(int blockNo, int columnNo, int rowNo, int seatTypePriority) {
		this.blockNo = blockNo;
		this.rowNo = columnNo ;
		this.columnNo = rowNo;
		this.seatTypePriority = seatTypePriority;
		this.seatTypeName = Constants.SEAT_NAMES[this.seatTypePriority-1];
	}
}