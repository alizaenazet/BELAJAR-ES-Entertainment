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
        System.out.printf("Artist List%n");
        System.out.printf("==========================================%n");
        // System.out.printf("| 3% | 5% | 10% | 3 | 5| %n ", "No", "ID", "NAME", "AGE",
        // "ROLE");
        for (int i = 0; i < artisLists.length; i++) {
            int no = i + 1;
            var id = artisLists[i][0];
            var name = artisLists[i][1];
            var age = artisLists[i][2];
            var role = artisLists[i][3];
            if (id != null && name != null) {
                System.out.print(no + " " + id.getArtisInfo() + " " + name.getArtisInfo() + " " + age.getArtisInfo()
                        + " " + role.getArtisInfo() + "\n");
            }
        }
        System.out.printf("==========================================%n");

    }

    @Override
    public void addArtisList(String nama, Integer age, String role) {

        ArtisList artisName = new ArtisList(nama);
        ArtisList artisAge = new ArtisList(String.valueOf(age));
        ArtisList artisRole = new ArtisList(role);

        if (age > 15 && nama.contains(" ") && (role.toLowerCase().equals("actress")
                || role.toLowerCase().equals("actor") || role.toLowerCase().equals("singer"))) {
            artisListRepo.add(artisName, artisAge, artisRole);
        } else if (age < 15) {
            System.out.println("Umur kurang dari 15 tahun ");

        } else if (!role.toLowerCase().equals("actress") || !role.toLowerCase().equals("Actor")
                || !role.toLowerCase().equals("Singer")) {
                    System.out.println("The role is not allowed");
        }
    }

    @Override
    public void removeArtisList(Integer number) {

        if (artisListRepo.remove(number)) {
            System.out.println("Berhasil dihapus");
        } else {
            System.out.println("Gagal menghapus");
        }

    }

}
