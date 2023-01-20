package tes;

import repository.ArtisListRepo;
import repository.ArtisListRepoImpl;
import service.ArtisListService;
import service.ArtisListServiceImpl;

public class ArtisListTest {

    public static void main(String[] args) {
        addArtisList();
    }

    private static void show() {
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);
        ArtisListRepoImpl artisListRepoImpl = new ArtisListRepoImpl();
       
        artisListService.showArtisList();
    }
    
    private static void addArtisList() {
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);

        artisListService.addArtisList("Justin bieber", 30, "Singer");
        // artisListService.showArtisList();
    }
}
