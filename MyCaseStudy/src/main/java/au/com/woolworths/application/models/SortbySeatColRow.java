package au.com.woolworths.application.models;

import java.util.Comparator;

public class SortbySeatColRow implements Comparator<Seat> {

	@Override
	public int compare(Seat firstSeat, Seat secondSeat) {
		if(firstSeat.getSeatTypePriority() == secondSeat.getSeatTypePriority()) {
			if(firstSeat.getColumnNo() == secondSeat.getColumnNo()) {
				return Integer.compare(firstSeat.getBlockNo(), secondSeat.getBlockNo());
			} else {
				return Integer.compare(firstSeat.getColumnNo(), secondSeat.getColumnNo());
			} 
		} else {
			return Integer.compare(firstSeat.getSeatTypePriority(), secondSeat.getSeatTypePriority());
		}
       
    }

}
