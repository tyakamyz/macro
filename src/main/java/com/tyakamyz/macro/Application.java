package com.tyakamyz.macro;

import com.tyakamyz.macro.domain.InterparkTicket;
import com.tyakamyz.macro.domain.NaverShopping;

public class Application {

    private static final String WEB_DRIVER_ID = "webdriver.chrome.driver"; // 드라이버 ID
    private static final String WEB_DRIVER_PATH = "D:\\IdeaProjects\\macro\\src\\main\\resources\\chromedriver.exe"; // 드라이버 경로

    static {
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
    }

    public static void main(String[] args) {
        String type = "INTERPARK_TICKET";
        String id = "";
        String pw = "";
        String targetUrl = "https://tickets.interpark.com/goods/22015806";

        switch (type) {
            case "NAVER_SHOPPING":
                naverShoppingMacro(id, pw, targetUrl);
                break;
            case "INTERPARK_TICKET":
                interparkTicketMacro(id, pw, targetUrl);
                break;
        }
    }

    private static void naverShoppingMacro(String id, String pw, String targetUrl) {
        //String targetUrl = "https://search.naver.com/p/crd/rd?m=1&px=602&py=228&sx=602&sy=228&p=h3trYsp0J1sssOGF%2FpGssssssyh-360131&q=%EC%9D%B5%EC%82%B0%EB%86%8D%ED%98%91%EB%96%A1%EB%B0%A9%EC%95%97%EA%B0%84&ie=utf8&rev=1&ssc=tab.nx.all&f=nexearch&w=nexearch&s=U52lnWse%2Bfblw0a%2FgaMnrw%3D%3D&time=1668312100231&abt=%5B%7B%22eid%22%3A%22SBR1%22%2C%22vid%22%3A%22490%22%7D%5D&u=https%3A%2F%2Fcr3.shopping.naver.com%2Fbridge%2FsearchGate%3Fquery%3D%25EC%259D%25B5%25EC%2582%25B0%25EB%2586%258D%25ED%2598%2591%25EB%2596%25A1%25EB%25B0%25A9%25EC%2595%2597%25EA%25B0%2584%26bt%3D-1%26nv_mid%3D84959545731%26cat_id%3D50013161%26h%3Df2521c2427fdb1439234a4856a28af0471b95dd0%26t%3DLAETVYX2%26frm%3DNVSCPRO&r=1&i=00000009_0013c7fbc983&a=shp_dui*a.outtit&cr=1";
        int optionIndex = 1;

        NaverShopping macro = new NaverShopping(id, pw, targetUrl);
        macro.start(optionIndex);
    }

    private static void interparkTicketMacro(String id, String pw, String targetUrl) {
        //String targetUrl = "https://tickets.interpark.com/goods/22015806";

        InterparkTicket macro = new InterparkTicket(id, pw, targetUrl);
        macro.start();
    }
}
