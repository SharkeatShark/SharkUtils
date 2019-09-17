package com.shark.io.poi;

import com.alibaba.fastjson.JSONArray;
import com.shark.util.StrUtil;
import com.sun.media.sound.InvalidFormatException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.hssf.util.Region;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * excel 工具类
 * @author sharkeatshark@foxmail.com
 * @create 2019-07-29-10:30
 * @projectName SharkUtils
 * @packageName com.shark.io.poi
 */
public class ExcelUtil {

    /**
     * 导出excel.xls
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response  返回响应
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     * @param sheetName    工作薄名称
     */
    public static void exportExcel(List list, HttpServletResponse response,
                                   String[] columnTitles, String[] columnValues, String title,
                                   String sheetName) {
        try (InputStream in = getInputStream(list, columnTitles, columnValues,title, sheetName);
             BufferedInputStream br = new BufferedInputStream(in);
             OutputStream out = response.getOutputStream()){
            byte[] buf = new byte[1024];
            int len = 0;
            // 非常重要
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            while ((len = br.read(buf)) > 0){
                out.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excel时设置列表信息
     *
     * @param prizelist
     * @param columnTitles
     * @param columnValues
     * @param title
     * @param sheetName
     * @return
     */
    public static InputStream getInputStream(List prizelist,
                                             String[] columnTitles, String[] columnValues, String title, String sheetName) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle herdStyle = wb.createCellStyle();
        herdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont herdFont = wb.createFont();
        herdFont.setFontHeightInPoints((short) 18);
        herdStyle.setFont(herdFont);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titleFont);

        titleStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle cellstyle = wb.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFSheet sheet = wb.createSheet(sheetName);
        sheet.setColumnWidth(0, 256 * 25);
        sheet.setColumnWidth(1, 256 * 25);
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell herdCell = row0.createCell(0);
        herdCell.setCellValue(title);
        herdCell.setCellStyle(herdStyle);
        sheet.addMergedRegion(new Region(0, (short) 0, 0,(short) (columnTitles.length - 1))); // 合并单元格
        HSSFRow row1 = sheet.createRow(1);
        for (int i = 0; i < columnTitles.length; i++) {
            HSSFCell titleCell = row1.createCell(i);
            titleCell.setCellValue(columnTitles[i]);
            titleCell.setCellStyle(titleStyle);
        }
        if (prizelist != null && prizelist.size() > 0) {
            for (int i = 0; i < prizelist.size(); i++) {
                Map prize = (Map) prizelist.get(i);
                HSSFRow row = sheet.createRow(i + 2);
                for (int j = 0; j < columnValues.length; j++) {
                    HSSFCell cell = row.createCell(j);
                    if (prize.get(columnValues[j]) == null) {
                        cell.setCellValue("");
                    } else {
                        cell.setCellValue(prize.get(columnValues[j]).toString());
                    }
                    cell.setCellStyle(cellstyle);
                }
            }
        }
        final File file = new File(StrUtil.generate6SerialId() + (".xls").toString());
        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        // 线程池操作
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 删除文件
                file.delete();
            }
        }).start();

        return is;
    }

    /**
     * 导出excel
     *
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     */
    public static void exportExcel(List list, HttpServletResponse response,
                                   String[] columnTitles, String[] columnValues, String title) {
        try {

            InputStream in = getInputStream(list, columnTitles, columnValues,
                    title);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 导出excle时设置列表信息
     *
     * @param prizelist
     * @param columnTitles
     * @param columnValues
     * @param title
     * @return
     */
    public static InputStream getInputStream(List prizelist,
                                             String[] columnTitles, String[] columnValues, String title) {

        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFCellStyle herdStyle = wb.createCellStyle();
        herdStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont herdFont = wb.createFont();
        herdFont.setFontHeightInPoints((short) 18);
        herdStyle.setFont(herdFont);
        HSSFCellStyle titleStyle = wb.createCellStyle();
        titleStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        HSSFFont titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleStyle.setFont(titleFont);

        titleStyle.setFillForegroundColor(HSSFColor.GREY_50_PERCENT.index);
        titleStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);

        HSSFCellStyle cellstyle = wb.createCellStyle();
        cellstyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        HSSFSheet sheet = wb.createSheet();

        sheet.setColumnWidth(0, 256 * 25);
        sheet.setColumnWidth(1, 256 * 25);
        HSSFRow row0 = sheet.createRow(0);
        HSSFCell herdCell = row0.createCell(0);
        herdCell.setCellValue(title);
        herdCell.setCellStyle(herdStyle);
        // sheet.AddMergedRegion(new Region(0, 0, 0, 5));

        sheet.addMergedRegion(new Region(0, (short) 0, 0,
                (short) (columnTitles.length - 1))); // 合并单元格

        HSSFRow row1 = sheet.createRow(1);
        //
        for (int i = 0; i < columnTitles.length; i++) {
            HSSFCell titleCell = row1.createCell(i);
            titleCell.setCellValue(columnTitles[i]);
            titleCell.setCellStyle(titleStyle);
        }

        if (prizelist != null && prizelist.size() > 0) {
            for (int i = 0; i < prizelist.size(); i++) {

                Map prize = (Map) prizelist.get(i);
                HSSFRow row = sheet.createRow(i + 2);

                for (int j = 0; j < columnValues.length; j++) {
                    HSSFCell cell = row.createCell(j);
                    if (prize.get(columnValues[j]) == null) {
                        cell.setCellValue("");
                    } else {
                        cell
                                .setCellValue(prize.get(columnValues[j])
                                        .toString());
                    }

                    cell.setCellStyle(cellstyle);
                }
            }
        }

        final File file = new File(StrUtil.generate6SerialId()
                + (".xls").toString());

        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.delete();
            }
        }).start();

        return is;
    }

    /**
     * 导出excel
     *
     * @param response 返回响应
     * @param workbook EXCEL文件
     * @param title    导出excel的标题
     */
    public static void exportExcel(HttpServletResponse response,
                                   HSSFWorkbook workbook, String title) {
        try {
            response.reset();
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/x-msdownload;charset=UTF-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + ".xls");
            OutputStream outStream = response.getOutputStream();
            workbook.write(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 把一张图片导出excel
     *
     * @param response
     * @param filenamePath 文件名的存放路径
     * @param title
     */
    public static void exportExcel(HttpServletResponse response, String filenamePath, String title) {
        try {

            InputStream in = getInputStream(filenamePath);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".xls");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 把后缀为.png图片导入Excel
     *
     * @param filenamePath 文件名的存放路径
     * @return
     */
    public static InputStream getInputStream(String filenamePath) {

        BufferedImage bufferImg = null;
        // 先把读进来的图片放到一个ByteArrayOutputStream中，以便产生ByteArray
        ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();

        try {
            bufferImg = ImageIO.read(new File(filenamePath));
            ImageIO.write(bufferImg, "png", byteArrayOut);
        } catch (IOException e2) {
            e2.printStackTrace();
        }

        // 创建一个工作薄
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet1 = wb.createSheet("new sheet");
        HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
        HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 512, 255,
                (short) 1, 1, (short) 10, 20);

        anchor.setAnchorType(2);
        // 插入图片
        patriarch.createPicture(
                anchor,
                wb.addPicture(byteArrayOut.toByteArray(),
                        HSSFWorkbook.PICTURE_TYPE_PNG)).resize();

        final File file = new File(StrUtil.generate6SerialId()
                + (".xls").toString());
        try {
            OutputStream os = new FileOutputStream(file);
            wb.write(os);
            os.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(7000);// 7秒钟
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                file.delete();
            }
        }).start();
        return is;
    }

    /**
     * 导出excel
     *
     * @param list         传入要导出的excel列表信息（list里必须是map类型）
     * @param response
     * @param columnTitles 以数组方式传入列名（相当于表头）
     * @param columnValues 以数组方式传入列内容（map键）
     * @param title        导出excel的标题
     * @param sheetName    工作薄名称
     */
    public static void exportExcel2(List list, HttpServletResponse response,
                                    String[] columnTitles, String[] columnValues, String title,
                                    String sheetName) {
        try {

            InputStream in = getInputStreamInfo(list, columnTitles, columnValues);
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] buf = new byte[1024];
            int len = 0;
            response.reset();
            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            String fileName = new String(title.getBytes("UTF-8"), "UTF-8");
            java.util.Date date1 = new java.util.Date();
            DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
            String timeStr = df.format(date1);
            response.setHeader("Content-Disposition", "attachment; filename="
                    + java.net.URLEncoder.encode(fileName, "UTF-8") + timeStr
                    + ".csv");
            OutputStream out = response.getOutputStream();
            while ((len = br.read(buf)) > 0)
                out.write(buf, 0, len);
            br.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取list数据流
     *
     * @param prizelist    列头数组
     * @param columnTitles 数据集合键值数组
     * @param columnValues sql语句
     * @return InputStream
     */
    public static InputStream getInputStreamInfo(List prizelist, String[] columnTitles, String[] columnValues) {
        //各类变量定义
        BufferedWriter bw = null;//输出流
        StringBuffer sb = null;//字符串容器
        InputStream is = null;//输入流
        try {
            //定义文件
            final File file = new File(StrUtil.generate6SerialId() + (".csv").toString());
            //各类变量赋值
            //bw = new BufferedWriter(new FileWriter(file));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "gb2312"));
            sb = new StringBuffer("");
            //判断列头是否为空
            if (columnTitles != null) {
                //设置列头
                for (int i = 0; i < columnTitles.length; i++) {
                    sb.append("\"" + columnTitles[i] + "\",");
                }
                bw.write(sb.toString().substring(0, sb.toString().length() - 1) + "\n");
            }

            //执行list获取结果集
            if (prizelist != null && prizelist.size() > 0) {
                for (int i = 0; i < prizelist.size(); i++) {
                    sb = new StringBuffer("");
                    Map prize = (Map) prizelist.get(i);
                    for (int j = 0; j < columnValues.length; j++) {
                        if (prize.get(columnValues[j]) != null)
                            sb.append("\"" + prize.get(columnValues[j]).toString() + "\",");
                        else
                            sb.append("\"\",");
                    }
                    bw.write(sb.toString().substring(0, sb.toString().length() - 1) + "\n");
                }
            }

            //关闭流
            bw.close();
            //读取数据流返回
            is = new FileInputStream(file);
            //设置删除文件的延时器
            new Thread(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(8000);//8秒钟
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    file.delete();
                }
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 获取Excel文件（.xls和.xlsx都支持）
     *
     * @param file
     * @return 解析excle后的Json数据
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InvalidFormatException
     */
    public JSONArray readExcel(File file, String fileName) throws Exception {
        int res = checkFile(file, fileName);

        if (res == 0) {
            System.out.println("File not found");
        } else if (res == 1) {
//			return readXLSX(file);
        } else if (res == 2) {
            return readXLS(file);
        }
        JSONArray array = new JSONArray();
        return array;
    }

    /**
     * 判断File文件的类型
     *
     * @param file
     *            传入的文件
     * @return 0-文件为空，1-XLSX文件，2-XLS文件，3-其他文件
     */
    public int checkFile(File file, String fileName) {
        if (file == null) {
            return 0;
        }
        if (fileName.endsWith("xlsx")) {
            return 1;
        }
        if (fileName.endsWith("xls")) {
            return 2;
        }
        return 3;
    }

    /**
     * 读取XLSX文件
     *
     * @param file
     * @return
     * @throws IOException
     * @throws InvalidFormatException
     */
    // public JSONArray readXLSX(File file) throws Exception {
    //
    // // Workbook book = new XSSFWorkbook(file);
    // // org.apache.poi.ss.usermodel.Sheet sheet = book.getSheetAt(0);
    // // return read(sheet, book);
    // }

    /**
     * 读取XLS文件
     *
     * @param file
     * @return
     * @throws IOException
     * @throws FileNotFoundException
     */
    public JSONArray readXLS(File file) throws FileNotFoundException,
            IOException {
        POIFSFileSystem poifsFileSystem = new POIFSFileSystem(
                new FileInputStream(file));
        Workbook book = new HSSFWorkbook(poifsFileSystem);
        Sheet sheet = book.getSheetAt(0);
        return read(sheet, book);
    }

    /**
     * 解析数据
     *
     * @param sheet
     *            表格sheet对象
     * @param book
     *            用于流关闭
     * @return
     * @throws IOException
     */
    public JSONArray read(Sheet sheet, Workbook book) throws IOException {
        int rowStart = sheet.getFirstRowNum(); // 首行下标
        int rowEnd = sheet.getLastRowNum(); // 尾行下标
        // 如果首行与尾行相同，表明只有一行，直接返回空数组
        if (rowStart == rowEnd) {
            return new JSONArray();
        }
        // 获取第一行JSON对象键
        Row firstRow = sheet.getRow(rowStart);
        int cellStart = firstRow.getFirstCellNum();
        int cellEnd = firstRow.getLastCellNum();
        // 获取每行JSON对象的值
        JSONArray array = new JSONArray();
        for (int j = cellStart; j < cellEnd; j++) {
            array.add(getValue(firstRow.getCell(j), rowStart, j, book, true));

        }
        for (int i = rowStart + 1; i <= rowEnd; i++) {
            Row eachRow = sheet.getRow(i);
            for (int k = cellStart; k < cellEnd; k++) {
                if (eachRow != null) {
                    String val = getValue(eachRow.getCell(k), i, k, book, false);
                    array.add(val);
                }
            }
        }
        return array;
    }

    /**
     * 获取每个单元格的数据
     *
     * @param cell
     *            单元格对象
     * @param rowNum
     *            第几行
     * @param index
     *            该行第几个
     * @param book
     *            主要用于关闭流
     * @param isKey
     *            是否为键：true-是，false-不是。 如果解析Json键，值为空时报错；如果不是Json键，值为空不报错
     * @return
     * @throws IOException
     */
    public String getValue(Cell cell, int rowNum, int index, Workbook book,
                           boolean isKey) throws IOException {

        // 空白或空
        if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
            if (isKey) {
                throw new NullPointerException(String.format(
                        "the key on row %s index %s is null ", ++rowNum,
                        ++index));
            } else {
                return "";
            }
        }

        // 0. 数字 类型
        if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
            if (HSSFDateUtil.isCellDateFormatted(cell)) {
                Date date = cell.getDateCellValue();
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                return df.format(date);
            }
            String val = cell.getNumericCellValue() + "";
            val = val.toUpperCase();
            if (val.contains("E")) {
                val = val.split("E")[0].replace(".", "");
            }
            return val;
        }

        // 1. String类型
        if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
            String val = cell.getStringCellValue();
            if (val == null || val.trim().length() == 0) {
                if (book != null) {
                }
                return "";
            }
            return val.trim();
        }

        // 2. 公式 CELL_TYPE_FORMULA
        if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
            return cell.getStringCellValue();
        }

        // 4. 布尔值 CELL_TYPE_BOOLEAN
        if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
            return cell.getBooleanCellValue() + "";
        }

        // 5. 错误 CELL_TYPE_ERROR
        return "";
    }

}
