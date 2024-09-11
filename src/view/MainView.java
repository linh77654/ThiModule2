package view;

import Controller.RegularPatientsController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private static RegularPatientsController regularPatientsController = new RegularPatientsController();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Chọn chức năng để sử dụng \n" +
                    "1. Thêm mới \n" +
                    "2. Xoá \n" +
                    "3. Xem danh sách bệnh án \n" +
                    "4. Thoát");
            System.out.print("Nhập sự lựa chọn của bạn: ");
            try {
                int choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        handleAddPatients(sc);
                        break;
                    case 2:
                        handleDeletePatients(sc);
                        break;
                    case 3:
                        handleViewPatients(sc);
                        break;
                    case 4:
                        running = false;
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Vui lòng nhập một số nguyên.");
                sc.next();
            }
        }
    }

    private static void handleAddPatients(Scanner sc) {
        System.out.println("1. Thêm bệnh án thường \n" +
                "2. Thêm bệnh án VIP \n" +
                "3. Thoát");
        System.out.print("Nhập lựa chọn: ");
        int addChoice = sc.nextInt();
        switch (addChoice) {
            case 1:
                regularPatientsController.addRegularPatients();
                System.out.println("Đã thêm bệnh án thường.");
                break;
            case 2:

                System.out.println("Đã thêm bệnh án VIP.");
                break;
            case 3:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    private static void handleDeletePatients(Scanner sc) {
        System.out.println("1. Xoá bệnh án thường \n" +
                "2. Xoá bệnh án VIP \n" +
                "3. Thoát");
        System.out.print("Nhập lựa chọn: ");
        int deleteChoice = sc.nextInt();
        switch (deleteChoice) {
            case 1:
                regularPatientsController.deleteRegularPatients();
                System.out.println("Đã xoá bệnh án thường.");
                break;
            case 2:
                System.out.println("Đã xoá bệnh án VIP.");
                break;
            case 3:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }

    private static void handleViewPatients(Scanner sc) {
        System.out.println("1. Xem danh sách bệnh án thường \n" +
                "2. Xem danh sách bệnh án VIP \n" +
                "3. Thoát");
        System.out.print("Nhập lựa chọn: ");
        int viewChoice = sc.nextInt();
        switch (viewChoice) {
            case 1:
                regularPatientsController.displayRegularPatients();
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                System.out.println("Lựa chọn không hợp lệ.");
                break;
        }
    }
}
