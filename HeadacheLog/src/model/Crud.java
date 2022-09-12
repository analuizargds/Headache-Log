package model;

/**
 * Interface com métodos de um CRUD que serão implementados pelas classes ControlerPain e ControlerMedicine
 * @see ControlerPain
 * @see ControlerMedicine
 * @author Ana Luiza Rodrigues da Silva
 */

import java.util.ArrayList;
import java.util.Date;

public interface Crud {

    public abstract boolean create(Object object);
    public abstract ArrayList<?> read(Date date);
    public abstract boolean update(Date date);
    public abstract void delete(Date date);

}
