package by.it.artemliashkov.jd03_03.beans;

public class Company {
    private long id;
    private String name;
    private String type;
    private int amount_agents;
    private String address;
    private int Agents_ID;

    public Company() {
    }

    public Company(long id, String name, String type ,int amount_agents,String address, int agents_ID) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.amount_agents = amount_agents;
        this.address=address;
        Agents_ID = agents_ID;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getAmountAgents() {
        return amount_agents;
    }

    public void setType(int amount_agents) {
        this.amount_agents = amount_agents;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAgents_ID() {
        return Agents_ID;
    }

    public void setAgents_ID(int agents_ID) {
        Agents_ID = agents_ID;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", amount_agents='" + amount_agents + '\'' +
                ", address='" + address + '\'' +
                ", Agents_ID=" + Agents_ID +
                '}';
    }

}
