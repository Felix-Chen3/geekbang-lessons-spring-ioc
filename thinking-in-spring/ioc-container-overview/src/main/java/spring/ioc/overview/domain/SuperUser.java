package spring.ioc.overview.domain;

import spring.ioc.overview.annotation.Super;

/**
 * @author felix
 * @date 2020/12/7
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 加入了super.toString
     */
    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
