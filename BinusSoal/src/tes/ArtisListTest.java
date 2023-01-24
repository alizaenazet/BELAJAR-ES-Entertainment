package tes;

import repository.ArtisListRepo;
import repository.ArtisListRepoImpl;
import service.ArtisListService;
import service.ArtisListServiceImpl;

public class ArtisListTest {

    public static void main(String[] args) {
        removeArtisList();
    }

    private static void showArtisList() {
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);
        
       
        // artisListService.addArtisList("Justin bieber", 25, "Singer");
        // artisListService.addArtisList("ariana grande", 16, "Singer");
        // artisListService.showArtisList();
        // artisListService.addArtisList("roma irama", 45, "Singer");
        artisListService.showArtisList();

    }

    private static void addArtisList() {
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);

        artisListService.addArtisList("Justin bieber", 25, "Singer");
        artisListService.addArtisList("ariana grande", 16, "Singer");
        artisListService.addArtisList("roma irama", 45, "Singer");
        showArtisList();
    }

    private static void removeArtisList(){
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);
        artisListService.addArtisList("Justin bieber", 25, "Singer");
        artisListService.addArtisList("ariana grande", 16, "Singer");
        artisListService.addArtisList("roma irama", 45, "Singer");
        artisListService.showArtisList();
        artisListService.removeArtisList(3);
        artisListService.showArtisList();
    }
}
