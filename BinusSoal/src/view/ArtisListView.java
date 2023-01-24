package view;

import Entities.ArtisList;
import Util.InputUtil;
import repository.ArtisListRepo;
import service.ArtisListService;

public class ArtisListView {
    private ArtisListService artisListService;
    boolean added = false;

    public ArtisListView(ArtisListService artisListService) {
        this.artisListService = artisListService;
    }

    public void homeApp() {

        while (true) {
            System.out.printf("ES Entertainmentt%n");
            System.out.printf("==========================================%n");

            var inputMenu = InputUtil.input("Pilih input\n1. Insert New Artist \n2. View Artist\n3. Delete Artist\n4. Exit");
            if (inputMenu.equals("1")) {
                insertNewArtist();
            } else if (inputMenu.equals("2")) {
                viewArtistList();
            } else if (inputMenu.equals("3")) {
                deleteArtist();
            } else if (inputMenu.equals("4")) {
                System.out.println("Exit Succes");
                break;
            }
        }
    }

    public void insertNewArtist() {
        try {
            System.out.println("--~ Insert Artist List --~\n");
            System.out.println("Insert '0' to exit");
            System.out.println(
                    "Insert the artist Name\nname must be between 5 and 25 characters (inclusive) and must contain exactly 2 words");
            String name = InputUtil
                    .input("name must be between 5 and 25 characters (inclusive) and must contain exactly 2 words");
            if (name.equals("0")) {
                
            } else {
                System.out.println("Insert Age");
                String age = InputUtil.input("the age must be at least 15 years old");
                if (age.equals("0")) {
                    
                } else {
                    System.out.println("Insert Artist role");
                    String role = InputUtil.input("Role must be either “Actress”, “Actor”, or “Singer” ");
                    if (role.equals("0")) {
                        
                    } else {
                        artisListService.addArtisList(name, Integer.parseInt(age), role);
                    }
                    ;
                    if (!added) {
                        added = true;
                    }
                }

            }

        } catch (Exception e) {
            
        }

    }

    public void viewArtistList() {
        try {
            if (added) {
                System.out.println("--~ Insert Artist List --~\n");
                artisListService.showArtisList();
                String exitInput = InputUtil.input("Press 'Enter' to contine");
            } else {
                System.out.println("There is no artist data");
                String exitInputs = InputUtil.input("Press 'Enter' to contine");
            }

        } catch (Exception e) {
            System.out.println("Something erorr");
            
        }

    }

    public void deleteArtist() {
        try {
            System.out.println("--~ Insert Artist List --~\n");
            artisListService.showArtisList();

            System.out.println("Insert Artist number will delete \bInsert '0' to cancel");
            if (added) {
                String numberBeDeleted = InputUtil.input("Chose artist number will delete");
                if (numberBeDeleted.equals("0")) {
                    
                } else {
                    String confirmInput = InputUtil.input("Are you sure want to delete this artist? [Yes | No ]");
                    if (confirmInput.toLowerCase().equals("yes")) {
                        artisListService.removeArtisList(Integer.parseInt(numberBeDeleted));
                        
                    } else {
                        deleteArtist();
                    }
                }

            } else {
                String noArtistExet = InputUtil.input("There is no artist data\nPress enter to continue... ");
                if (noArtistExet == null || noArtistExet.isEmpty() || noArtistExet.isBlank()) {
                    
                }
            }

        } catch (Exception e) {
            System.out.println("Something erorr");
           
        }
    }
}
