import com.DAO.DAO;
import com.model.CatEntity;

/**
 * Created by User on 09.06.2017.
 * For testing
 */
public class Main {
    public static void main(String[] args) {
        DAO dao = new DAO();
        CatEntity cat = new CatEntity();
        cat.setName("Cat");
        cat.setWeight(20);
        dao.addCat(cat);
    }
}
