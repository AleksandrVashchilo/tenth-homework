import java.util.List;
import java.util.Set;

public class Worker extends Person implements AbleToCalculatePension {

    private static final int MONEY_PER_CHILD = 200;
    private double minSalary;
    private double maxSalary;

    private List<Company> companyList;

    public double getMinSalary() {
        return minSalary;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public List<Company> getCompanyList() {
        return companyList;
    }

    private Set<PensionFund> availablePensionFunds;

    public Set<PensionFund> getAvailablePensionFunds() {
        return availablePensionFunds;
    }

    public void setAvailablePensionFunds(Set<PensionFund> availablePensionFunds) {
        this.availablePensionFunds = availablePensionFunds;
    }

    public void setCompanyList(List<Company> companyList) {
        this.companyList = companyList;
    }

    public void infoAboutCompany() {
        System.out.print("Я работал в следующих компаниях: ");
        boolean start = true;

        for (Company company : companyList) {
            if (start) {
                System.out.print(company.getName());
                start = false;
            } else {
                System.out.print(", " + company.getName());
            }
        }
    }
        @Override
        public void die () {
            System.out.println("Этот человек не дожил до пенсии");
        }

        @Override
        public double calculatePension () {
            int age = getAge();
            int additionalSalary = 0;
            if (getChildren() != null) {
                additionalSalary = getChildren().size() * MONEY_PER_CHILD;
            }
            additionalSalary += minSalary;
            double maxPension = 0.0;
            for (PensionFund fund : availablePensionFunds) {
                double result = fund.calculatePension(age, minSalary + additionalSalary, maxSalary);
                if (result > maxPension) {
                    maxPension = result;
                }
            }
            return maxPension;
        }
    }

