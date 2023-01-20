package repository;

import Entities.ArtisList;

public interface ArtisListRepo {
    ArtisList[][] getAll();

    void add(ArtisList name, ArtisList age , ArtisList Role);
    boolean remove(Integer number);

 
}
