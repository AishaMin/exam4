import jakarta.persistence.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_groups")
public class Group {

 //   private int group;
    private Climber arrayClimbers[];
    @Column
    public int climberCount = 3;
    @Column
    private boolean recruitedGroup;


    @Column (name = "group_id")
    @Id
    private int id;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Climber> climbers = new HashSet<>();
    @OneToOne (optional = false)
    @JoinColumn (name = "mountain_id")
    private Mountain mountain;





    public void setMountain(Mountain mountain) {
        if (mountain == null){
            throw new IllegalArgumentException("Гора не может быть null");
        }
        this.mountain = mountain;
    }

    public void setClimberCount(int climberCount) {
        if (climberCount < 0 || climberCount > 3){
            throw new IllegalArgumentException("количество альпинистов не может быть меньше нуля, " +
                    "а так же в группе не может быть больше трех участников");
        } else if (climberCount < 3){
            recruitedGroup = false; // группа не закрыта
        } else
            recruitedGroup = true;
        this.climberCount = climberCount;
    }

    public void arrayClimbers (Climber climber){
        for (int i = 0; i < arrayClimbers.length; i++) {
            if (arrayClimbers[i] == null){
                arrayClimbers[i] = climber;
            }
        }
        recruitedGroup = true;
        System.out.println("Группа закрыта");
    }



    @Override
    public String toString() {
        return "Group{" +
               // "group=" + group +
                ", arrayClimbers=" + Arrays.toString(arrayClimbers) +
                ", climberCount=" + climberCount +
                ", recruitedGroup=" + recruitedGroup +
                ", mountain=" + mountain +
                '}';
    }

}
