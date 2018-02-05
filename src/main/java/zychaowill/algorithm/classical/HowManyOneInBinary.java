package zychaowill.algorithm.classical;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HowManyOneInBinary {

	private Integer number;

	public int numberOfOne() {
		Objects.requireNonNull(number, "Could not accept a empty number to execute numberOfOne operation!");
		
		int count = 0;

		while (number != 0) {
			count++;
			number = number & (number - 1);
		}
		return count;
	}

}
