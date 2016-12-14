package model.persistance;

import controller.ShopController;
import model.client.Customer;
import model.product.CD;
import model.product.Game;
import model.product.Movie;
import model.product.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.PrintSetup;

class ToExcel implements Persistable {
    @Override
    public void init() {
    }

    @Override
    public void save(ShopController shopController) {
        List<Dumpable> dumpableList = new ArrayList<>();
        dumpableList.addAll(shopController.getProductsHashMap().values());
        dumpableList.addAll(shopController.getCustomerHashMap().values());
        File file = new File("shop.txt");

        HSSFWorkbook wb;

        wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("Shop Data");

        PrintSetup printSetup = sheet.getPrintSetup();
        sheet.setAutobreaks(true);
        printSetup.setFitHeight((short)1);
        printSetup.setFitWidth((short)1);

        int iRow = 0;
        for (Dumpable dump : dumpableList) {
            String sDump[] = dump.dump().split(",");
            HSSFRow row = sheet.createRow(iRow);
            for(int iCell = 0; iCell < 2 ; iCell++){
                HSSFCell cell = row.createCell(iCell);
                cell.setCellValue(sDump[iCell]);
            }
            iRow++;
        }
        try {
            FileOutputStream out = new FileOutputStream(file);
            wb.write(out);
            out.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public HashMap<String, Product> loadProducts() {
        HashMap<String, Product> productList = new HashMap<>();
        try {
            String id = null, type = null, title = null;
            
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("file.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for(int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if(row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if(row != null) {
                    for(int c = 0; c < cols; c++) {
                        cell = row.getCell((short)c);
                        if(cell != null) {
                            switch (c){
                                case 0:
                                    id = cell.getStringCellValue();
                                    break;
                                case 1:
                                    title = cell.getStringCellValue();
                                    break;
                                case 2:
                                    type = cell.getStringCellValue();
                                    break;
                            }
                        }
                    }
                    assert type != null;
                    switch (type) {
                        case "CD":
                            productList.put(id, new CD(title, id));
                            break;
                        case "Movie":
                            productList.put(id, new Movie(title, id));
                            break;
                        case "Game":
                            productList.put(id, new Game(title, id));
                            break;
                    }
                }
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }
        return productList;
    }

    @Override
    public HashMap<String, Customer> loadCustomers() {
        HashMap<String, Customer> customerList = new HashMap<>();
        try {
            String name = null, type = null, email = null;

            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream("file.xlsx"));
            HSSFWorkbook wb = new HSSFWorkbook(fs);
            HSSFSheet sheet = wb.getSheetAt(0);
            HSSFRow row;
            HSSFCell cell;

            int rows; // No of rows
            rows = sheet.getPhysicalNumberOfRows();

            int cols = 0; // No of columns
            int tmp = 0;

            // This trick ensures that we get the data properly even if it doesn't start from first few rows
            for(int i = 0; i < 10 || i < rows; i++) {
                row = sheet.getRow(i);
                if(row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 0; r < rows; r++) {
                row = sheet.getRow(r);
                if(row != null) {
                    for(int c = 0; c < cols; c++) {
                        cell = row.getCell((short)c);
                        if(cell != null) {
                            switch (c){
                                case 0:
                                    name = cell.getStringCellValue();
                                    break;
                                case 1:
                                    email = cell.getStringCellValue();
                                    break;
                                case 2:
                                    type = cell.getStringCellValue();
                                    break;
                            }
                        }
                    }
                    if(type.equals("customer")){
                        customerList.put(name, new Customer(name, email));
                    }
                }
            }
        } catch(Exception ioe) {
            ioe.printStackTrace();
        }
        return customerList;
    }
}
