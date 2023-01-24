import repository.ArtisListRepo;
import repository.ArtisListRepoImpl;
import service.ArtisListService;
import service.ArtisListServiceImpl;
import view.ArtisListView;

public class ESEntertainmentApp {
    public static void main(String[] args) {
        ArtisListRepo artisListRepo = new ArtisListRepoImpl();
        ArtisListService artisListService = new ArtisListServiceImpl(artisListRepo);
        ArtisListView artisListView = new ArtisListView(artisListService);

        artisListView.homeApp();
    }
}
