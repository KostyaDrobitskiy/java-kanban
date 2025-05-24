package manager;

public class IdManager {
   static private Integer id = 1;
    static public Integer addId() {
        return id++;
    }
}
