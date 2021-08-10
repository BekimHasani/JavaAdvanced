package exercises.ushtrimi2.entity;

public class Contract {

    private String customer_id;
    private String name;
    private String contract_id;

    public Contract(String customer_id, String contract_id, String name) {
        this.contract_id = contract_id;
        this.name = name;
        this.customer_id = customer_id;
    }

    public String getContractId() {
        return contract_id;
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("(Contract) %s [%s]", name, contract_id);
    }
}
