package au.com.woolworths.application.models;

import java.util.Comparator;

public class SortbyColRow implements Comparator<Seat> {

	@Override
	public int compare(Seat firstSeat, Seat secondSeat) {
		if(firstSeat.getColumnNo() > secondSeat.getColumnNo()) {
			return Integer.compare(firstSeat.getColumnNo(), secondSeat.getColumnNo());
		} else if(firstSeat.getColumnNo() == secondSeat.getColumnNo()) {
			if(firstSeat.getBlockNo() == secondSeat.getBlockNo()) {
				return Integer.compare(firstSeat.getRowNo(), secondSeat.getRowNo());
			}
			return Integer.compare(firstSeat.getBlockNo(), secondSeat.getBlockNo());
		} else {
			return Integer.compare(firstSeat.getColumnNo(), secondSeat.getColumnNo());
		}
       
    }

}


