import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table (name = "tb_mountains")
public class Mountain {
    @Column (name = "mountain_name")
    private String name;
    @Column
    private String countryName;
    @Column
    private int height;
    @Column
    private LocalDateTime dateOfAscent;
    @Column (name = "mountain_id")
    @Id
    private int id;
    @OneToOne (optional = false)
    @JoinColumn (name = "group_id")
    private Group group;


    public Mountain(String name, String countryName, int height, LocalDateTime dateOfAscent){
        if (name == null || name.length() < 4){
            throw new IllegalArgumentException("Название горы должно быть не менее четырех символов");
        }
        if (countryName == null || countryName.length() < 4){
            throw new IllegalArgumentException("Название страны должно быть не менее четырех символов");
        }
        if (height < 100){
            throw new IllegalArgumentException("Высота горы не должна быть менее ста метров");
        }

        this.name = name;
        this.countryName = countryName;
        this.height = height;
        this.dateOfAscent = dateOfAscent;
    }
    public LocalDateTime getDateOfAscent() {
        return dateOfAscent;
    }

    public void setDateOfAscent() {
        this.dateOfAscent = dateOfAscent;
    }

    @Override
    public String toString() {
        return "Mountain{" +
                "name='" + name + '\'' +
                ", countryName='" + countryName + '\'' +
                ", height=" + height +
                '}';
    }

}
