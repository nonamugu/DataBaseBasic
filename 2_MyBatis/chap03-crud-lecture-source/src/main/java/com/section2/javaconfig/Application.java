package com.section2.javaconfig;

import com.section2.javaconfig.MenuController;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuController menuController = new MenuController();

        do {
            System.out.println("======== 메뉴 관리 ===========");
            System.out.println("1. 전체 메뉴 조회하기");
            System.out.println("2. 메뉴 코드로 메뉴 조회하기");
            System.out.println("3. 신규 메뉴 등록하기");
            System.out.println("4. 기존 메뉴 수정하기");
            System.out.println("5. 메뉴 삭제하기");
            System.out.print("관리할 메뉴 번호를 선택해주세요 : ");
            int no = sc.nextInt();

            switch (no) {
                case 1 : menuController.selectAllMenu(); break;
                case 2 : menuController.selectMenuByCode(inputMenuCode()); break;
                case 3 : menuController.registMenu(inputMenu()); break;
                case 4 : menuController.modifyMenu(inputModifyMenu()); break;
                case 5 : menuController.deleteMenu(inputMenuCode()); break;
                default :
                    System.out.println("잘못된 번호를 입력하셨습니다. ");
            }

        } while(true);
    }

    private static Map<String, String> inputMenuCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("대상 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);

        return parameter;
    }

    public static Map<String, String> inputMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("새로 둥록할 메뉴명을 입력하세요 : ");
        String name= sc.nextLine();
        System.out.print("등록할 메뉴의 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("등록할 메뉴의 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

    public static Map<String, String> inputModifyMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.print("수정하고 싶은 메뉴 코드를 입력하세요 : ");
        String code = sc.nextLine();
        System.out.print("수정할 메뉴의 이름을 입력하세요 : ");
        String name = sc.nextLine();
        System.out.print("메뉴의 수정된 가격을 입력하세요 : ");
        String price = sc.nextLine();
        System.out.print("메뉴의 수정된 카테고리 코드를 입력하세요 : ");
        String categoryCode = sc.nextLine();

        Map<String, String> parameter = new HashMap<>();
        parameter.put("code", code);
        parameter.put("name", name);
        parameter.put("price", price);
        parameter.put("categoryCode", categoryCode);

        return parameter;
    }

}
