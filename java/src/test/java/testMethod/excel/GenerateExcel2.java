package testMethod.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hslf.model.Sheet;
import org.apache.poi.hslf.record.Sound;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class GenerateExcel2 {

    private String[] titles = new String[]{"手机号码"};
    private int contentSize = 50000;
    private String[] contents = new String[]{""};
    private String fileName = "/tmp/10-2.xlsx";

    @Test
    public void test() throws FileNotFoundException, IOException {
        System.err.println("time=" + System.currentTimeMillis());
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet();


        Row row0 = sheet.createRow(0);
        for (int i = 0; i < titles.length; i++) {
            Cell cell = row0.createCell(i);
            cell.setCellValue(titles[i]);
        }
        // 具体内容
        List<String> segments = Arrays.asList("133", "155", "156", "157", "158", "180", "182", "183", "190", "192");
        Random random = new Random();
        for (int i = 1; i <= contentSize; i++) {
            Row row = sheet.createRow(i);

//            String perfix = i + "";
//            while (perfix.length() < 6) {
//                perfix = "0" + perfix;
//            }
            
            int suffixLength = 11 - 3;

            String mobile = segments.get(random.nextInt(9)) + StringUtils.leftPad(String.valueOf(i), suffixLength, "0");
            for (int j = 0; j < contents.length; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue(mobile);
            }
        }
        System.err.println("time=" + System.currentTimeMillis());
//		XSSFSheet sheet1 = xssfWorkbook.createSheet();
//		
//		XSSFRow row0_1 = sheet1.createRow(0);
//		for(int i = 0; i < titles.length; i ++) {
//			XSSFCell cell = row0_1.createCell(i);
//			cell.setCellValue(titles[i]);
//			cell.setCellStyle(createCellStyle);
//		}
//		// 具体内容
//		for(int i = 1; i <= contentSize; i++) {
//			XSSFRow row = sheet1.createRow(i);
//			
//			for(int j = 0; j < contents.length; j ++) {
//				XSSFCell cell = row.createCell(j);
//				cell.setCellValue(i + "A" + contents[j]);
//				cell.setCellStyle(createCellStyle);
//			}
//		}

        workbook.write(new FileOutputStream(new File(fileName)));
        System.err.println("time=" + System.currentTimeMillis());
        System.out.println(sheet.getLastRowNum());
    }
    
    private String generateOne() {
        Random random = new Random();
        int first = random.nextInt(70);
        int second = random.nextInt(10000);
        int third = random.nextInt(10000);
        return String.format("1%02d%04d%04d", first + 30, second, third);
    }
    
    private String encrypt(String text) {
        StringBuilder sb = new StringBuilder();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");

            md.update(text.getBytes("UTF-8"));
        } catch (Exception e) {
            return null;
        }
        byte[] b = md.digest();

        for (int offset = 0; offset < b.length; ++offset) {
            int i = b[offset];
            if (i < 0) {
                i += 256;
            }

            if (i < 16) {
                sb.append("0");
            }

            sb.append(Integer.toHexString(i));
        }

        return sb.toString();
    }

}
