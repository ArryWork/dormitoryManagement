package com.fafu.dormitorymanage.service.impl;

import com.fafu.dormitorymanage.dao.DormitoryMapper;
import com.fafu.dormitorymanage.dao.ManagerMapper;
import com.fafu.dormitorymanage.dao.StudentMapper;
import com.fafu.dormitorymanage.pojo.Manager;
import com.fafu.dormitorymanage.pojo.Student;
import com.fafu.dormitorymanage.service.ManagerService;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static org.apache.poi.ss.usermodel.Cell.CELL_TYPE_NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;

/**
 * Created by 林强 on 2017-03-31.
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    public ManagerMapper managerMapper;

    @Autowired
    public DormitoryMapper dormitoryMapper;

    @Autowired
    public StudentMapper studentMapper;
    @Override
    public Manager login(Manager manager) throws Exception {
        return managerMapper.getManager(manager);
    }

    @Override
    public List<Student> getStudentList(MultipartFile file) {
        List<Student> students = new ArrayList<>();
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(file.getInputStream());
            for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
                XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
                if (xssfSheet == null) {
                    continue;
                }
                // 获取当前工作薄的每一行
                for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
                    XSSFRow xssfRow = xssfSheet.getRow(rowNum);
                    if (xssfRow != null) {
                        String dormitory = xssfRow.getCell(0).getStringCellValue();
                        int roomOrd = (int) xssfRow.getCell(1).getNumericCellValue();
                        String name = String.valueOf(xssfRow.getCell(2));
                        String isHead = String.valueOf(xssfRow.getCell(3));
                        if("是".equals(isHead))
                            isHead="1";
                        else
                            isHead="0";
//                        double cellValue =  xssfRow.getCell(4).getNumericCellValue();
//                        String studentNo = new DecimalFormat("#").format(cellValue);
                        String studentNo =xssfRow.getCell(4).getStringCellValue();

                        String major = String.valueOf(xssfRow.getCell(5));
                        xssfRow.getCell(6).setCellType(CELL_TYPE_NUMERIC);
                        int grade = (int) xssfRow.getCell(6).getNumericCellValue();
                        xssfRow.getCell(7).setCellType(CELL_TYPE_NUMERIC);

                        int class_no = (int) xssfRow.getCell(7).getNumericCellValue();
                        students.add(new Student(roomOrd, name, isHead, studentNo, major, grade, class_no, dormitory));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public Map getDomitoryId() {
        List<Map> dormitoryMap = dormitoryMapper.getIdNameMap();
        Map idNameMap = new HashMap();
        dormitoryMap.forEach(new Consumer<Map>() {
            @Override
            public void accept(Map map) {
                idNameMap.put(map.get("name"),map.get("id"));
            }
        });
        return idNameMap;
    }

    @Override
    public int addNewStudent(List<Student> students) {
        return studentMapper.addNewStudent(students);

    }
}
