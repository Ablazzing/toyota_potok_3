package com.javaacademy.toyota.shop;

import com.javaacademy.toyota.car.type.Car;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Отчет
 */
public class Report {
    private final String managerName;
    private final Car[] soldCars = new Car[1_000];
    private int countSoldCars = 0;

    public Report(String managerName) {
        this.managerName = managerName;
    }

    /**
     * Внесение машины в отчет
     *
     * @param car - проданная машина
     */
    public void addSoldCar(Car car) {
        soldCars[countSoldCars] = car;
        countSoldCars++;
    }

    /**
     * Создание отчета в файле
     *
     * @param filename - полный путь до файла
     */
    public void createFileReport(String filename) {
        try (FileWriter fileWriter = new FileWriter(filename)) {
            fileWriter.append(createTextReport());
        } catch (IOException e) {
            System.out.println("Невозможно записать в файл репорт");
        }
    }

    /**
     * Создание текстовой версии отчета
     *
     * @return - текст отчета
     */
    private String createTextReport() {
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append(managerName).append("\n");
        joinCarsReport(reportBuilder);
        return reportBuilder.toString();
    }

    /**
     * Генерация отчета по машинам
     *
     * @param report - текст отчета
     */
    private void joinCarsReport(StringBuilder report) {
        BigDecimal totalIncome = new BigDecimal(0);
        BigDecimal totalOutcome = new BigDecimal(0);
        for (int i = 0; i < countSoldCars; i++) {
            Car soldCar = soldCars[i];
            totalIncome = totalIncome.add(soldCar.getCarModel().getPrice());
            totalOutcome = totalOutcome.add(soldCar.getCarModel().getFactoryCost());
            report.append(soldCar.getCarModel())
                    .append(" - ")
                    .append(soldCar.getCarModel().getPrice())
                    .append(" - ")
                    .append(soldCar.getCarModel().getFactoryCost())
                    .append("\n");
        }
        report.append("Итог: доходы - ")
                .append(totalIncome)
                .append(", расходы - ")
                .append(totalOutcome)
                .append(", прибыль - ")
                .append(totalIncome.subtract(totalOutcome));
    }
}
