import jakarta.persistence.*;

@Entity
@Table (name = "tb_climbers")
public class Climber {
    @Column (name = "climber_name")
    private String name;
    @Column(name = "climber_address")
    private String address;
    @Column (name = "climber_id")
    @Id
    private int id;
    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn (name = "group_id")
    private Group group;


    public Climber(String name, String address){
        if (name == null || name.length() < 3){
            throw new IllegalArgumentException("Имя должно быть не менее трех символов");
        }
        if (address == null || address.length() < 5){
            throw new IllegalArgumentException("Адресс не должен быть менее пяти символов");
        }
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Climber{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
