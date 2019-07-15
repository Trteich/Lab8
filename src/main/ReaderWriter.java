package main;

import customer.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ReaderWriter {
    private File file;

    ReaderWriter(String filename) {
          file = new File(filename);
    }

    List<Customer> readAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String[] strings = reader.readLine().split(";");
            List<Customer> result = new ArrayList<>();
            for (String string : strings) {
                String[] s = string.split(" ");
                int id;
                try {
                    id = Integer.parseInt(s[0]);
                } catch (NumberFormatException e) {
                    id = 0;
                }
                result.add(new Customer(id,s[1],s[2],s[3],s[4],Integer.parseInt(s[5]),Double.parseDouble(s[6])));
            }
            return result;
        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }
    void writeAll(List<Customer> arr)  {
        try(FileWriter wrt = new FileWriter(file)) {
            for (int i = 0; i < arr.size(); i++) {
                wrt.write(arr.get(i).str());
                if (i != (arr.size() - 1)) {
                    wrt.write(";");
                }
            }
        } catch (IOException x){
            x.printStackTrace();
        }

    }
}
