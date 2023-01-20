package repository;

import java.util.Random;
import java.util.jar.Attributes.Name;

import javax.print.attribute.standard.MediaSize.NA;

import Entities.ArtisList;

public class ArtisListRepoImpl implements ArtisListRepo {

    public ArtisList[][] data = new ArtisList[5][3];

    @Override
    public ArtisList[][] getAll() {
        return data;
    }

    private String GenerateId(ArtisList name) {

        String first;
        String last;
        String[] spliter = name.split(" ");
        first = spliter[0];
        last = spliter[spliter.length];
        Random random = new Random();
        int zzz = 0;
        while (true) {
            if (zzz < 100 || zzz == 1000) {
                zzz = random.nextInt(1000);

            } else {
                break;
            }
        }
        String result = String.valueOf(first.charAt(0)) + String.valueOf(last.charAt(0) + String.valueOf(zzz));

        return result;
    }

    boolean isFull() {
        boolean isFull = true;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] == null) {
                isFull = false;
            }
        }
        return isFull;
    }

    void Resize() {
        if (isFull()) {
            var sementara = data;
            data = new ArtisList[data.length + 1][3];
            for (int i = 0; i < sementara.length; i++) {
                data[i][0] = sementara[i][0];
                data[i][1] = sementara[i][1];
                data[i][2] = sementara[i][2];
                data[i][3] = sementara[i][3];
            }

        }
    }

    @Override
    public void add(ArtisList name, ArtisList age, ArtisList role) {
        Resize();

        ArtisList id = new ArtisList(GenerateId(name));

        for (int i = 0; i < data.length; i++) {

            if (data[i][0] != null) {
                data[i][0] = id;   //<---- Erorr 
                data[i][1] = name;
                data[i][2] = age;
                data[i][3] = role;
                System.out.println("Berhasil menambahkan artis");
                break;
            }
        }
    }

    @Override
    public boolean remove(Integer number) {

        if (data[(number - 1)][0] == null) {
            return false;
        } else if (number == (data.length + 1)) {
            data[(number - 1)][0] = null;
            data[(number - 1)][1] = null;
            data[(number - 1)][2] = null;
            data[(number - 1)][3] = null;
            return true;
        } else {
            for (int i = (number - 1); i < data.length; i++) {
                data[(i)][0] = data[(i + 1)][0];
                data[(i)][1] = data[(i + 1)][1];
                data[(i)][2] = data[(i + 1)][2];
                data[(i)][3] = data[(i + 1)][3];
            }
            return true;
        }
    }

}
