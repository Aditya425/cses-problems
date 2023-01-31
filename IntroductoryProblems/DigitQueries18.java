import java.util.*;

public class DigitQueries18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long q = sc.nextLong();
		long[] powerOfTen = new long[19];
		Arrays.fill(powerOfTen, 1);
		for (int i = 1; i <= 18; i++) {
			powerOfTen[i] = powerOfTen[i - 1] * 10;
		}
        while (q-- > 0) {
            long index = sc.nextLong();
			long digitsTillNow = 0;
			long digitsForPreviousBlock = 0;
			int numberOfDigits = 0;
			for (int i = 1; i < 19; i++) {
				digitsTillNow += (powerOfTen[i] - powerOfTen[i - 1]) * i;
				if (digitsTillNow >= index) {
					numberOfDigits = i;
					break;
				}
				digitsForPreviousBlock += (powerOfTen[i] - powerOfTen[i - 1]) * i;
			}
			long smallestValue = powerOfTen[numberOfDigits - 1];
			long largestValue = powerOfTen[numberOfDigits] - 1;
			long bestValue = 0;
			long positionOfBestValue = 0;
			while (smallestValue <= largestValue) {
				long mid = (smallestValue + largestValue) / 2;
				long positionOfMid = digitsForPreviousBlock + 1 + (mid - powerOfTen[numberOfDigits - 1]) * numberOfDigits;
				if (positionOfMid <= index) {
					if (mid > bestValue) {
						bestValue = mid;
						positionOfBestValue = positionOfMid;
					}
					smallestValue = mid + 1;
				} else {
					largestValue = mid - 1;
				}
			}
			//System.out.println(bestValue);
			String bestValueString = String.valueOf(bestValue);
			int position = (int) (index - positionOfBestValue);
			System.out.println(bestValueString.charAt(position));
        }
        sc.close();
    }
}
