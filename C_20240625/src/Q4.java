import java.util.Scanner;

class Account {
    private String accountNumber; // 계좌번호
    private String ownerName;     // 소유자 이름
    private int balance;          // 잔액

    // 생성자
    public Account(String accountNumber, String ownerName, int balance) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // 계좌 정보 출력 메소드
    public void printAccountInfo() {
        System.out.printf("계좌번호 : %s, 계좌주 : %s, 초기입금액 : %d\n", accountNumber, ownerName, balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public int addcash(int amount) {
        balance += amount;
        return balance;
    }

    public int subcash(int amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("잔액이 부족합니다.");
        }
        return balance;
    }

    @Override
    public String toString() {
        return accountNumber + "  " + ownerName + "  " + balance + '\n';
    }
}

public class Q4 {
    private static Account[] accounts = new Account[3];
    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            printMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(scanner);
                    break;
                case 2:
                    printAllAccounts();
                    break;
                case 3:
                    deposit(scanner);
                    break;
                case 4:
                    withdraw(scanner);
                    break;
                case 5:
                    System.out.println("프로그램을 종료합니다.");
                    running = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
        scanner.close();
    }

    private static void createAccount(Scanner scanner) {
        System.out.println("--------" +
                "\n계좌 생성" +
                "\n--------");
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("계좌주 이름: ");
        String ownerName = scanner.next();
        System.out.print("초기 입금액: ");
        int balance = scanner.nextInt();
        accounts[count++] = new Account(accountNumber, ownerName, balance);
        System.out.println("결과 : 계좌가 생성되었습니다.");
    }

    private static void printAllAccounts() {
        System.out.println("--------" +
                "\n계좌 목록" +
                "\n--------");
        for (int i = 0; i < count; i++) {
            accounts[i].printAccountInfo();
        }
    }

    private static void deposit(Scanner scanner) {
        System.out.println("--------" +
                "\n예금" +
                "\n--------");
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("예금액: ");
        int cashin = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].addcash(cashin);
                System.out.println("입금 종료");
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.println("--------" +
                "\n출금" +
                "\n--------");
        System.out.print("계좌번호: ");
        String accountNumber = scanner.next();
        System.out.print("출금액: ");
        int cashout = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equals(accountNumber)) {
                accounts[i].subcash(cashout);
                System.out.println("출금 종료");
                found = true;
                return;
            }
        }
        if (!found) {
            System.out.println("계좌를 찾을 수 없습니다.");
        }
    }

    public static void printMenu() {
        System.out.println("=====================================================" +
                "\n1. 계좌 생성 | 2. 계좌 목록 | 3. 예금 | 4. 출금 | 5. 종료" +
                "\n=====================================================");
        System.out.print("\n선택 > ");
    }
}
