import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculate {
	static int readInt() throws java.io.IOException {
		char ch;
		int n = 0;
		int sign = 1;

		// skip non-character

		while (!Character.isDigit(ch = (char) System.in.read()) && ch != '-');

		if (ch == '-') { 
			sign = -1;
			ch = (char) System.in.read();
		}

		do {
			n = n * 10 + (ch - '0');
			ch = (char) System.in.read();
		} while (Character.isDigit(ch));
		return n * sign;

	}

	public static void main(String[] args) throws Exception {
		System.out.println("1900년 이후의 날짜(year-month-day): ");
		String start = "19000101";
		int year = readInt(); //year 를 읽어와 int 형 변수 year에 저장
		int month = readInt(); //month 를 읽어와 int 형 변수 month에 저장
		int day = readInt(); //day를 읽어와 int 형 변수 day에 저장
		int total_day = 0; //총 날짜 계산하기 위한 변수
		String end = "" + year + month + day;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); //SimpleDateFormat
		Date beginDate = formatter.parse(start); //String을 date형식으로 parse
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMd");
		Date endDate = formatter2.parse(end);

		long diff = endDate.getTime() - beginDate.getTime();

		long diffDays = diff / (24 * 60 * 60 * 1000); //일수 계산을 위해 나눠준다.

		System.out.println("1900-1-1부터 날짜수는 " + (diffDays + (long) 1));

		total_day += (year - 1900) * 365; // 1900년도 이후 모든 날짜 계산
		total_day += (year - 1900) / 4; // 윤년으로 추가되는 날짜의 수

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			//4로 나누어 떨어지면 윤년, 그 중에 100으로 나누어 떨어지면 평년, 그 중에 400으로 나누어 떨어지면 윤년
			if ((month == 1) || (month == 2)) { //
				total_day += -1;
			}
		}
		switch (month) {
		case 1:
			total_day += day;
			break;
		case 2:
			total_day += 31 + day;
			break;
		case 3:
			total_day += 31 + 28 + day;
			break;
		case 4:
			total_day += 31 + 28 + 31 + day;
			break;
		case 5:
			total_day += 31 + 28 + 31 + 30 + day;
			break;
		case 6:
			total_day += 31 + 28 + 31 + 30 + 31 + day;
			break;
		case 7:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + day;
			break;
		case 8:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + 31 + day;
			break;
		case 9:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + day;
			break;
		case 10:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + day;
			break;
		case 11:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + day;
			break;
		case 12:
			total_day += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30
					+ day;
			break;
		default: //12월 이후의 달은 없으므로 프로그램 종료
			System.out.println("Wrong Input!!!");
			return;
		}
		System.out.print(year + "-" + month + "-" + day + "의 요일은 ");
		switch (total_day % 7) {
		case 0:
			System.out.println("일요일");
			break;
		case 1:
			System.out.println("월요일");
			break;
		case 2:
			System.out.println("화요일");
			break;
		case 3:
			System.out.println("수요일");
			break;
		case 4:
			System.out.println("목요일");
			break;
		case 5:
			System.out.println("금요일");
			break;
		case 6:
			System.out.println("토요일");
			break;
		default:
			System.out.println("Wrong!");
			break;
		}
	}
}
