package Controller;

import model.RegularPatients;
import service.IRegularPatientsService;
import service.impl.RegularPatientsService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RegularPatientsController {
    private IRegularPatientsService regularPatientsService = new RegularPatientsService();
    private Scanner scanner = new Scanner(System.in);
    private AtomicInteger orderNumberCounter;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public RegularPatientsController() {

        int maxOrderNumber = regularPatientsService.getMaxOrderNumber();
        orderNumberCounter = new AtomicInteger(maxOrderNumber + 1);
    }

    public void displayRegularPatients() {
        List<RegularPatients> patientsList = regularPatientsService.getAll();
        if (!patientsList.isEmpty()) {
            for (RegularPatients patient : patientsList) {
                System.out.println(patient);
            }
        } else {
            System.out.println("Không có bệnh án nào.");
        }
    }

    public void addRegularPatients() {
        System.out.println("Nhập tên bệnh nhân:");
        String name = scanner.nextLine();

        LocalDate dateOfAdmission = null;
        while (dateOfAdmission == null) {
            try {
                System.out.println("Nhập ngày nhập viện (dd-MM-yyyy):");
                dateOfAdmission = LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày nhập viện không hợp lệ! Vui lòng nhập lại (định dạng dd-MM-yyyy).");
            }
        }

        LocalDate hospitalDischargeDate = null;
        while (hospitalDischargeDate == null) {
            try {
                System.out.println("Nhập ngày xuất viện (dd-MM-yyyy):");
                hospitalDischargeDate = LocalDate.parse(scanner.nextLine(), formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Ngày xuất viện không hợp lệ! Vui lòng nhập lại (định dạng dd-MM-yyyy).");
            }
        }

        System.out.println("Nhập lý do nhập viện:");
        String reasonForHospitalization = scanner.nextLine();

        int hospitalFees = -1;
        while (hospitalFees < 0) {
            try {
                System.out.println("Nhập phí bệnh viện:");
                hospitalFees = Integer.parseInt(scanner.nextLine());
                if (hospitalFees < 0) {
                    System.out.println("Phí bệnh viện không thể nhỏ hơn 0. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Phí bệnh viện không hợp lệ! Vui lòng nhập lại.");
            }
        }

        RegularPatients patient = new RegularPatients(
                generateNextOrderNumber(),
                generateMedicalRecordCode(),
                name,
                dateOfAdmission,
                hospitalDischargeDate,
                reasonForHospitalization,
                hospitalFees
        );

        regularPatientsService.addRegularPatients(patient);
        System.out.println("Thêm bệnh án thành công.");
    }

    public void deleteRegularPatients() {
        int medicalRecordCode = -1;
        while (medicalRecordCode < 0) {
            try {
                System.out.println("Nhập mã bệnh án cần xóa:");
                medicalRecordCode = Integer.parseInt(scanner.nextLine());
                if (medicalRecordCode < 0) {
                    System.out.println("Mã bệnh án phải là số dương. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã bệnh án không hợp lệ! Vui lòng nhập lại.");
            }
        }

        regularPatientsService.deleted(medicalRecordCode);
        System.out.println("Xóa bệnh án thành công.");
    }

    public void searchRegularPatients() {
        int medicalRecordCode = -1;
        while (medicalRecordCode < 0) {
            try {
                System.out.println("Nhập mã bệnh án để tìm kiếm:");
                medicalRecordCode = Integer.parseInt(scanner.nextLine());
                if (medicalRecordCode < 0) {
                    System.out.println("Mã bệnh án phải là số dương. Vui lòng nhập lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Mã bệnh án không hợp lệ! Vui lòng nhập lại.");
            }
        }

        int finalMedicalRecordCode = medicalRecordCode;
        RegularPatients patient = regularPatientsService.getAll().stream()
                .filter(p -> p.getMedicalRecordCode() == finalMedicalRecordCode)
                .findFirst()
                .orElse(null);

        if (patient != null) {
            System.out.println(patient);
        } else {
            System.out.println("Không tìm thấy bệnh án với mã này.");
        }
    }

    private String generateNextOrderNumber() {
        return "BA-" + String.format("%04d", orderNumberCounter.getAndIncrement());
    }

    private int generateMedicalRecordCode() {
        return orderNumberCounter.getAndIncrement();
    }
}
