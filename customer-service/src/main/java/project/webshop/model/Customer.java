package project.webshop.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("customer")
public class Customer {
    // Customer: customerId, firstname, lastname, email, password, createDate

    @PrimaryKey("customer_id")
    private UUID customerId;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

    @Column("email")
    private String email;

    @Column("password")
    private String password;

    @Column("created")
    private Date createDate;

    public Customer(UUID customerId, String firstName, String lastName,
                    String password, Date createDate) {
        super();
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;

        if (createDate != null) {
            this.createDate = createDate;
        } else {
            this.createDate = new Date();
        }
    }

    public Customer(UUID userId, String firstName, String lastName,
                    Date createDate) {
        super();
        this.customerId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", firstName=" + firstName
                + ", lastName=" + lastName + ", createDate=" + createDate + "]";
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Customer() {
        super();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
