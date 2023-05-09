import java.util.Scanner;
public class movie1{
    public static void main(String[]args) {
        int [][] seats = new int[10][10]; // 좌석예약 정보를 저장할 10x10크기의 2차원 배열 seat 생성

        // 반복문 실행여부를 true로 초기화
        //반복문을 무한히 실행하지 않고 특정 조건을 만족하면 반복을 종료하도록 하기위해 isRun변수 사용
        boolean isRun = true;


        String strColumn; // 열 이름을 저장하는 문자열 변수 선언
        char inputColumn; // 입력받은 열 이름을 저장하는 문자변수 선언

        // 행번호를 저장하는 변수 선언
        int rowNum;

        Scanner sc = new Scanner(System.in); // 사용자의 입력을 받기 위한 scanner 객체 생성

        do { //do-while 루프 , 사용자가 종료를 선택할 때까지 반복실행

            System.out.println();
            System.out.println("────────────────────────────────────SCREEN────────────────────────────────────");
            System.out.println();
            for (int i = 0; i < seats.length; i++) {
                System.out.print(" ["+(i+1)+"] "); //1부터 seats배열의 길이까지 반복하면서 각 행번호를 순차적으로 출력
            }
            System.out.println(" [행] ");

            for (int i = 0; i < seats.length; i++) { //배열의 행을 순회하는 반복문, 좌석상태 출력
                System.out.println();
                for (int j = 0; j < seats[i].length; j++) { //각 행의 열을 순회하는 반복문

                    if(seats[i][j] == 0) { //현재 좌석이 예약되지 않은상태(0)인 경우 빈칸네모 출력
                        System.out.print("[ □ ]");
                    }else {
                        System.out.print("[ ■ ]"); // 현재 좌석이 예약된 상태(1)인 경우 색칠네모 출력
                    }
                }
                System.out.println(" ["+(char)(i+65)+"] 열");
            } // 열번호에 해당하는 알파벳을 변환하여 출력 A부터 시작하는 문자는 (char)(i+65)를 통해 구할수있음.
            // 출력 형식은 [열알파벳]열
            System.out.print("───────────────────────────────────────────────────────────────────────────────");
            System.out.print("\n예약하실 좌석의 열을 입력해주세요 (예약종료는 exit) : ");

            strColumn = sc.next();

            if(strColumn.equals("exit")) {
                System.out.println("종료되었습니다");
                break; // 입력이 exit 인 경우 프로그램 종료
            }
            //입력받은 문자열의 첫번째 글자를 추출하여 inputColumn에 저장
            inputColumn = strColumn.trim().charAt(0);
            System.out.println("입력한 열 : " +inputColumn);

            if(inputColumn < 65 || inputColumn > 74) {
                System.out.println("선택할 수 없는 좌석입니다");
                continue;
            } // 입력받은 열 이름이 A부터 J(아스키문자)의 범위를 벗어날 경우, 선택할 수 없는 좌석이라고
            // 출력한 후 반복문의 처음으로 돌아감

            int column = inputColumn - 65;
            //inputColumn에 해당하는 열 인덱스를 계산하여 column 변수에 저장합니다. 'A'는 65의 유니코드 값을 가지므로, 'A'부터 'J'까지의 범위를 0부터 9까지의 인덱스로 변환

            System.out.print("예약하실 좌석의 행 번호를 입력해주세요 : ");
            rowNum = sc.nextInt(); // 사용자로부터 행 번호를 입력받아 rowNum에 저장

            if(rowNum < 1 || rowNum > 10) {
                System.out.println("선택할 수 없는 행 번호입니다");
                continue;
                //입력받은 행 번호가 1부터 10 범위를 벗어날 경우 출력 > 반복문 처음으로 돌아감
            }

            if (seats[column][rowNum - 1] ==1) { //사용자가 선택한 좌석이 이미 예약된 좌석인지를 확인하는 조건
                // seats배열에서 선택한 좌석의 예약상태를 확인해봤을때, 1인경우 예약으로 처리
                System.out.println("이미 예약된 좌석입니다");
                continue;
            }

            System.out.println("선택하신 좌석은 : " +inputColumn+ " 열이고 " + rowNum + " 행입니다");
            System.out.println("예약 완료 하시겠습니까 ? (Yes / No) : ");

            String s = sc.next(); //사용자로부터 입력을 받아 변수에 저장
            if(s.equals("y") || s.equals("Y")) { // 사용자가 y 또는 Y를 입력한 경우 확인
                seats[column][rowNum - 1] = 1; // 선택한 좌석의 예약 상태를 1로 변경,
                //행번호는 1부터 시작하므로 rowNum에서 1을 뺀 인덱스에 해당하는 요소를 변경
                System.out.println("예약이 완료되었습니다");
            }else {
                System.out.println("예약이 취소되었습니다"); //이외의 값을 입력한 경우 처리
                isRun = false; // 반복문 종료를 위해 변수를 false로 변경
            }

        } while (isRun); // isRun 변수가 true인 동안 반복문을 계속 실행

    }
}



