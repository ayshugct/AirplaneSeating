package au.com.woolworths.application.models;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5538203560422625806L;
	
	
	private List<String> successMessage;
	private List<String> errorMessage;
	private List<Seat> seatsList;
	
}
