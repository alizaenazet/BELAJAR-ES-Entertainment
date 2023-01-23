package service;

import Entities.ArtisList;
import repository.ArtisListRepo;
import repository.ArtisListRepoImpl;

public class ArtisListServiceImpl implements ArtisListService {
    ArtisListRepo artisListRepo = new ArtisListRepoImpl();

    public ArtisListServiceImpl(ArtisListRepo artisListRepoImpl) {
        this.artisListRepo = artisListRepoImpl;
    }

    @Override
    public void showArtisList() {
        ArtisList[][] artisLists = artisListRepo.getAll();
        System.out.println("hello");
        System.out.printf("Artist List%n");
        System.out.printf("==========================================%n");
        System.out.printf("| 3% | 5% | 10% | 3 | 5| %n ", "No", "ID", "NAME", "AGE", "ROLE");
        for (int i = 0; i < artisLists.length; i++) {
            var artis = artisLists[i][0];
            if (artis != null) {
                System.out.printf("| 3% | 5% | 10% | 3 | 5| %n ", artisLists[i][0], artisLists[i][1], artisLists[i][2], artisLists[i][2], artisLists[i][3]);
            }
        }
        System.out.printf("==========================================%n");

        

    }

    @Override
    public void addArtisList(String nama, Integer age, String role) {
       ArtisList artisName = new ArtisList(nama);
       ArtisList artisAge = new ArtisList(String.valueOf(age));
       ArtisList artisRole = new ArtisList(role);
       if (age < 15) {
        System.out.println("Umur kurang dari 15 tahun tes cuy");
       }else{
        artisListRepo.add(artisName, artisAge, artisRole);
        System.out.println("Berhasil menambah");
       }

    }

    @Override
    public void removeArtisList(Integer number) {
        // TODO Auto-generated method stub

    }

}
