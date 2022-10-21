package employee;

import dto.EmployeeDto;


public class Employee {

    // Personel veritabanına statik olarak veri ekler
    static EmployeeDto employeeDto = new EmployeeDto("Oguzhan Arslan", 10000F,45F,2016);


    //Personel bilgilerini console'ye yazdırır
    public static void employeeToString() {
        System.out.println("Adı: " + employeeDto.getName());
        System.out.println("Maas: " + employeeDto.getSalary());
        System.out.println("Çalışma Saati: " + employeeDto.getWorkHours());
        System.out.println("Giriş Yılı: " + employeeDto.getHireYear());
        System.out.println("*********************************************");
    }

    //Vergiyi hesaplar. (Maaş 1000TL'den fazla ise %3 vergi)
    public static Float tax() {

        Float salary = employeeDto.getSalary();
        if (salary < 1000) {
            return 0F;

        } else {
            System.out.println("Vergi: " + salary * 0.03F + "TL");
            return salary * 0.03F;
        }
    }

    //Bonus para hesaplar. Çalışılan saat 40 dan fazla ise saat başı 30tl verir.
    public static Float bonus() {
        Float workHours = employeeDto.getWorkHours();
        if (workHours > 40) {
            System.out.println("Bonus: " + (workHours - 40) * 30 + "TL");
            return workHours = (workHours - 40) * 30;
        } else {
            return 0F;
        }
    }

    //Maaş yükseltme metodu
    public static void raiseSalary() {

        int workedYears = 2021 - employeeDto.getHireYear();

        System.out.println("Eski Maas: " + employeeDto.getSalary() + "TL");
        if (workedYears < 10) {
            System.out.println("Personel 10 seneden az çalıştığı için %5 zam yapılmıştır");
            System.out.println("Zam Tutarı: " + employeeDto.getSalary() * 0.05F);
            employeeDto.setSalary((employeeDto.getSalary() + employeeDto.getSalary() * 0.05F) + tax() + bonus());

        } else if (workedYears > 9 && workedYears < 20) {
            System.out.println("Personel 9 seneden fazla 20 seneden az çalıştığı için %10 zam yapılmıştır");
            System.out.println("Zam Tutarı: " + employeeDto.getSalary() * 0.10F);
            employeeDto.setSalary((employeeDto.getSalary() + employeeDto.getSalary() * 0.10F) + tax() + bonus());

        } else if (workedYears > 19) {
            System.out.println("Personel 19 seneden fazla çalıştığı için %15 zam yapılmıştır");
            System.out.println("Zam Tutarı: " + employeeDto.getSalary() * 0.15F);
            employeeDto.setSalary((employeeDto.getSalary() + employeeDto.getSalary()  * 0.15F) + tax() + bonus());
        }

        System.out.println("Yeni Maas: " + employeeDto.getSalary() + "TL");
    }


    //Ana program
    public static void main ( String [] arguments ) {
        employeeToString();
        raiseSalary();
    }


}
