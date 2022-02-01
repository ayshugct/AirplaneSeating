package au.com.woolworths.application.business;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

import org.springframework.stereotype.Service;

import au.com.woolworths.application.models.SortbyColRow;
import au.com.woolworths.application.models.SortbySeatColRow;
import au.com.woolworths.application.models.Response;
import au.com.woolworths.application.models.Seat;

@Service
public class AirplaneSeatingBusiness {

	public Response getPassengerSeatDetails(int[][] array, int totalPassenger) {
		Response response = new Response();
		List<String> msg = new ArrayList<String>();
		List<Seat> seats = initialiseSeats(array);

		if (!validateSeatsForPassenger(seats, totalPassenger)) {
			msg.add("Total passengers in queue is greater than total available seats(" + seats.size()
					+ ") in Airplane");
			response.setErrorMessage(msg);
			return response;
		}
		Collections.sort(seats, new SortbyColRow());
		msg.add("Seat Allocation completed successfully.");
		response.setSuccessMessage(msg);
		response.setSeatsList(seats);
		return response;
	}

	public List<Seat> initialiseSeats(int[][] inputArray) {

		List<Seat> seats = new ArrayList<Seat>();
		for (int set = 1; set <= inputArray.length; set++) {
			for (int column = 1; column <= inputArray[set - 1][0]; column++) {
				for (int row = 1; row <= inputArray[set - 1][1]; row++) {
					if (set == 1 && column == 1 && inputArray[set - 1][0] > 1) {
						seats.add(new Seat(set, column, row, 2)); // Seat Type as Window
					} else if (set == inputArray.length && column == inputArray[set - 1][0]
							&& inputArray[set - 1][0] > 1) {
						seats.add(new Seat(set, column, row, 2)); // Seat Type as Window
					} else if (column == 1 || column == (inputArray[set - 1][0])) {
						seats.add(new Seat(set, column, row, 1)); // Seat Type as Aisle
					} else {
						seats.add(new Seat(set, column, row, 3)); // Seat Type as Center
					}
				}
			}
		}

		Collections.sort(seats, new SortbySeatColRow());
		return seats;
	}

	public boolean validateSeatsForPassenger(List<Seat> seats, int totalPassenger) {
		boolean isValid = true;
		if (seats.size() < totalPassenger) {
			isValid = false;
		} else {
			int passenger = 0;
			for (Seat s : seats) {
				if (passenger < totalPassenger)
					s.setPassengerNo(++passenger);
			}
		}
		return isValid;
	}
}
