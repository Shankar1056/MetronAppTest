package partner.softgalli.sqlitetest.model;

public class Employee {

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String Id, age, address;
    public Employee(String Id, String age, String address){
        this.Id = Id;
        this.age = age;
        this.address = address;
    }
}
