package com.example.employee;

import java.time.LocalDate;

/**
 * 正社員を表すクラス。
 */
public class FullTimeEmployee extends Employee {

    private final String positionName;
    private int allowance;

    public FullTimeEmployee(String employeeId, String name, String deptId,
                            int annualSalary, LocalDate hireDate,
                            String positionName, int allowance) {
        super(employeeId, name, deptId, annualSalary, hireDate);
        this.positionName = positionName;
        this.allowance = allowance;
    }

    /**
     * 月額給与 = 年俸÷12 + 役職手当
     */
    @Override
    public int calcMonthlySalary() {
        return annualSalary / 12 + allowance;
    }

    /**
     * 役職名を返す。
     */
    public String getPositionName() {
        return positionName;
    }

    public int getAllowance() {
        return allowance;
    }

    /**
     * 年俸の増加率に合わせて役職手当も更新する。
     */
    @Override
    public void updateAnnualSalary(int newSalary) {

        allowance = (int) Math.round(
                (double) allowance * newSalary / annualSalary
        );

        super.updateAnnualSalary(newSalary);
    }

    @Override
    public String getEmployeeType() {
        return "正社員";
    }
}