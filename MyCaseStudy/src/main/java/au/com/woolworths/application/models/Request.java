/**
 * 
 */
package au.com.woolworths.application.models;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author xkkyi
 *
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Request implements Serializable {
	private static final long serialVersionUID = -7378625835100027519L;

	private int queueSize;
	private int[][] arrayInputSize;
}
