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
		System.out.println("1900�� ������ ��¥(year-month-day): ");
		String start = "19000101";
		int year = readInt(); //year �� �о�� int �� ���� year�� ����
		int month = readInt(); //month �� �о�� int �� ���� month�� ����
		int day = readInt(); //day�� �о�� int �� ���� day�� ����
		int total_day = 0; //�� ��¥ ����ϱ� ���� ����
		String end = "" + year + month + day;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd"); //SimpleDateFormat
		Date beginDate = formatter.parse(start); //String�� date�������� parse
		SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMd");
		Date endDate = formatter2.parse(end);

		long diff = endDate.getTime() - beginDate.getTime();

		long diffDays = diff / (24 * 60 * 60 * 1000); //�ϼ� ����� ���� �����ش�.

		System.out.println("1900-1-1���� ��¥���� " + (diffDays + (long) 1));

		total_day += (year - 1900) * 365; // 1900�⵵ ���� ��� ��¥ ���
		total_day += (year - 1900) / 4; // �������� �߰��Ǵ� ��¥�� ��

		if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
			//4�� ������ �������� ����, �� �߿� 100���� ������ �������� ���, �� �߿� 400���� ������ �������� ����
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
		default: //12�� ������ ���� �����Ƿ� ���α׷� ����
			System.out.println("Wrong Input!!!");
			return;
		}
		System.out.print(year + "-" + month + "-" + day + "�� ������ ");
		switch (total_day % 7) {
		case 0:
			System.out.println("�Ͽ���");
			break;
		case 1:
			System.out.println("������");
			break;
		case 2:
			System.out.println("ȭ����");
			break;
		case 3:
			System.out.println("������");
			break;
		case 4:
			System.out.println("�����");
			break;
		case 5:
			System.out.println("�ݿ���");
			break;
		case 6:
			System.out.println("�����");
			break;
		default:
			System.out.println("Wrong!");
			break;
		}
	}
}
