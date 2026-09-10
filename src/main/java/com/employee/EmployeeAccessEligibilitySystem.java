package com.employee;

class Employee {

    String employeeId;
    String name;
    int age;
    String department;
    String employmentType;
    String securityClearance;
    boolean validId;
    boolean active;

    Employee(String employeeId, String name, int age,
             String department, String employmentType,
             String securityClearance, boolean validId,
             boolean active) {

        this.employeeId = employeeId;
        this.name = name;
        this.age = age;
        this.department = department;
        this.employmentType = employmentType;
        this.securityClearance = securityClearance;
        this.validId = validId;
        this.active = active;
    }

    void checkEligibility(String requestedAccess) {

        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Requested Access: " + requestedAccess);

        boolean eligible = true;
        boolean clearanceOK = true;

        // Age check
        if (age < 21) {
            System.out.println("Rejected: Employee is under 21.");
            eligible = false;
        }

        // Department check
        if (!(department.equalsIgnoreCase("IT")
                || department.equalsIgnoreCase("HR")
                || department.equalsIgnoreCase("Finance")
                || department.equalsIgnoreCase("Administration"))) {

            System.out.println("Rejected: Unauthorized department.");
            eligible = false;
        }

        // Employment status check
        if (!active) {
            System.out.println("Rejected: Employment status is not active.");
            eligible = false;
        }

        // Employee ID check
        if (!validId) {
            System.out.println("Rejected: Invalid employee ID.");
            eligible = false;
        }

        // Security clearance check
        if (requestedAccess.equalsIgnoreCase("Confidential")) {

            if (!(securityClearance.equalsIgnoreCase("High")
                    || securityClearance.equalsIgnoreCase("Top Secret"))) {

                System.out.println(
                    "Rejected: Insufficient security clearance."
                );

                clearanceOK = false;
            }
        }

        // Final result
        if (!eligible) {
            System.out.println("Final Result: NOT ELIGIBLE");

        } else if (!clearanceOK) {
            System.out.println("Final Result: CONDITIONALLY ELIGIBLE");

        } else {
            System.out.println("Final Result: ELIGIBLE");
        }

        System.out.println("-----------------------------");
    }
}


public class EmployeeAccessEligibilitySystem {

    public static void main(String[] args) {

        // Employee 1 - Eligible
        Employee employee1 = new Employee(
                "EMP001",
                "Raghul",
                25,
                "IT",
                "Full-Time",
                "High",
                true,
                true
        );

        // Employee 2 - Underage
        Employee employee2 = new Employee(
                "EMP002",
                "Arun",
                20,
                "IT",
                "Full-Time",
                "High",
                true,
                true
        );

        // Employee 3 - Unauthorized department
        Employee employee3 = new Employee(
                "EMP003",
                "John",
                30,
                "Sales",
                "Full-Time",
                "High",
                true,
                true
        );

        // Employee 4 - Conditional due to low clearance
        Employee employee4 = new Employee(
                "EMP004",
                "Kumar",
                35,
                "Finance",
                "Full-Time",
                "Low",
                true,
                true
        );

        // Employee 5 - Invalid ID
        Employee employee5 = new Employee(
                "EMP005",
                "David",
                40,
                "HR",
                "Full-Time",
                "High",
                false,
                true
        );

        // Employee 6 - Inactive employee
        Employee employee6 = new Employee(
                "EMP006",
                "Suresh",
                28,
                "IT",
                "Full-Time",
                "High",
                true,
                false
        );

        System.out.println("EMPLOYEE ACCESS ELIGIBILITY SYSTEM");
        System.out.println("===================================");

        employee1.checkEligibility("Confidential");
        employee2.checkEligibility("Confidential");
        employee3.checkEligibility("Normal");
        employee4.checkEligibility("Confidential");
        employee5.checkEligibility("Normal");
        employee6.checkEligibility("Normal");
    }
}